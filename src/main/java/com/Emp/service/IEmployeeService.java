package com.Emp.service;

import java.util.List;

import com.Emp.exception.EmployeeAlreadyExistsException;
import com.Emp.exception.EmployeeDoesNotExistsException;
import com.Emp.model.Employee;

public interface IEmployeeService {
	   public Employee addEmployee(Employee emp) throws EmployeeAlreadyExistsException;
	   public List<Employee> getEmployeeById(int empId);
	   public Employee updateEmployee(Employee emp)throws EmployeeDoesNotExistsException;
	   public Employee deleteEmployee(int empId)throws EmployeeDoesNotExistsException; 
}
