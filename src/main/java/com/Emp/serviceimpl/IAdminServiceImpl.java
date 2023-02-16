package com.Emp.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emp.exception.AdminAlreadyExistException;
import com.Emp.exception.AdminIdNotFoundException;
import com.Emp.exception.NoAdminFoundException;
import com.Emp.model.Admin;
import com.Emp.repository.IAdminRepository;
import com.Emp.service.IAdminService;
@Service
public class IAdminServiceImpl implements IAdminService{
	@Autowired
	private IAdminRepository repository;
	Logger logger=org.slf4j.LoggerFactory.getLogger(IAdminServiceImpl.class);
	@Override
	public Admin addAdmin(Admin admin) throws AdminAlreadyExistException {
		if(repository.existsById(admin.getAdminId())) {
			logger.error("Admmin Already Exist Exception");
			throw new AdminAlreadyExistException("Admin Already Exists");
		}
		else {
			logger.info("Admin added Succesfully");
			return repository.save(admin);
		}
	}

	@Override
	public Admin updateAdmin(Admin admin) throws NoAdminFoundException {

		
		int status=0;
		int adId=admin.getAdminId();
		String contactNumber=admin.getContactNumber();
		String emailId=admin.getEmailId();
		status=repository.updateAdminById(contactNumber, emailId, adId);
		if(status>=1) 
			return admin;
		
		return null;
	}

	@Override
	public void removeAdmin(int adminId) throws NoAdminFoundException {

		Admin admin=repository.getById(adminId);
		if(repository.existsById(adminId))
			repository.delete(admin);
		
	}

	

	@Override
	public List<Admin> viewAllAdmins() {
		return repository.getAllAdmins();
		}
	

	@Override
	public Admin getAdminById(int AdminId) {
		
		return repository.findById(AdminId).get();
	}


	}


