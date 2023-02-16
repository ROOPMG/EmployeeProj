package com.Emp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="employee_info")
public class Employee 
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int empId;
  @NotBlank(message="Employee name sholud not be blank")
  private String empName;
 @Pattern(regexp="[A-Za-z0-9]+[@]{1}[a-zA-z]+[.]{1}[a-z]{3}")
  private String emailId;
 //@Pattern(regexp="(0|91)?[7-9][0-9]{9}")
  private long phoneNo;
  private String department;
  private String location;
public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

public String getEmpName() {
	return empName;
}

public void setEmpName(String empName) {
	this.empName = empName;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public long getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

  
}
