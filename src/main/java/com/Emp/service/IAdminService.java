package com.Emp.service;

import java.util.List;

import com.Emp.exception.AdminAlreadyExistException;
import com.Emp.exception.AdminIdNotFoundException;
import com.Emp.exception.NoAdminFoundException;
import com.Emp.model.Admin;

public interface IAdminService {
	public Admin addAdmin(Admin admin)throws AdminAlreadyExistException;
	public Admin updateAdmin(Admin admin)throws NoAdminFoundException;
	public void removeAdmin(int adminId)throws NoAdminFoundException;
	public List<Admin>viewAllAdmins();
	public Admin getAdminById(int AdminId);
}
