package com.Emp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emp.exception.EmployeeAlreadyExistsException;
import com.Emp.exception.EmployeeDoesNotExistsException;
import com.Emp.model.Employee;
import com.Emp.repository.IEmployeeRepository;
import com.Emp.service.IEmployeeService;

@Service
public class IEmployeeServiceImpl implements IEmployeeService{
	 @Autowired
	 private IEmployeeRepository repository;
	 Logger logger =org.slf4j.LoggerFactory.getLogger(IEmployeeServiceImpl.class);
	 
	@Override
	public Employee addEmployee(Employee emp) throws EmployeeAlreadyExistsException {
		if (repository.existsById(emp.getEmpId())){
			logger.error("Employee Already Exist Exception");
			throw new EmployeeAlreadyExistsException("Employee Already Exists");
			
		}
		else 
		{
				logger.info("Employee added Succesfully");
				return repository.save(emp);
			}
			}
	@Override
	public List<Employee> getEmployeeById(int empId) {
	 
			   return repository.getEmployeeById(empId);
	}
	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeDoesNotExistsException {
		if(repository.existsById(emp.getEmpId())) {
			logger.info("Employee Update Successfully");
			return repository.save(emp);
		}
		else {
			logger.error("no employee found to update");
			throw new EmployeeDoesNotExistsException(" No Employee found to update");
	}}
	@Override
	public Employee deleteEmployee(int empId) throws EmployeeDoesNotExistsException {
		Optional<Employee> em=repository.findById(empId);
		Employee emp;
		if(em.isEmpty()) {
			throw new EmployeeDoesNotExistsException("Employee not found with"+  " "+empId);
				}
		else {
			emp=em.get();
			repository.delete(emp);
		}
		return emp;
	}
}
