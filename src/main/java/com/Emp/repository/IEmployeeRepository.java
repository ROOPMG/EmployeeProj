package com.Emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Emp.exception.EmployeeDoesNotExistsException;
import com.Emp.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
	
	@Query(value="delete from employee_info where empId=?1",nativeQuery = true)
		 public Employee deleteEmployee(int empId)throws EmployeeDoesNotExistsException;
		
	//@Query(value="select e from Employee_info  where empId=?1",nativeQuery = true)
	@Query(value="select * from employee_info  where emp_id=?1",nativeQuery = true)
	public List<Employee> getEmployeeById(int empId);
}
