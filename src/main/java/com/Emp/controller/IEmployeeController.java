package com.Emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Emp.exception.EmployeeAlreadyExistsException;
import com.Emp.exception.EmployeeDoesNotExistsException;
import com.Emp.model.Employee;
import com.Emp.serviceimpl.IEmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class IEmployeeController {
	@Autowired
	
	private IEmployeeServiceImpl empl;
	@PostMapping(path="/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) throws EmployeeAlreadyExistsException{
		return empl.addEmployee(emp);
	}
	
@DeleteMapping(path="/DeleteEmployee/{empId}")
public ResponseEntity<String> deleteEmployee(@PathVariable int empId)throws  EmployeeDoesNotExistsException{
	try {
		empl.deleteEmployee(empId);
	}
	catch(EmployeeDoesNotExistsException ne) {
		throw ne;
	}
	return new ResponseEntity<String>("Employee delete Successfully",HttpStatus.OK);
}

@PutMapping(path="/updateEmployee")
public Employee updateEmployee(@RequestBody Employee emp)throws EmployeeDoesNotExistsException {
	return empl.updateEmployee(emp);
}
  
@GetMapping(path="/getEmployeeById/{empId}")
public List<Employee> getEmployeeById(@PathVariable int empId)
{
return empl.getEmployeeById(empId);
}





}
