package com.Emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Emp.exception.AdminAlreadyExistException;
import com.Emp.exception.AdminIdNotFoundException;
import com.Emp.exception.NoAdminFoundException;
import com.Emp.model.Admin;
import com.Emp.serviceimpl.IAdminServiceImpl;

@RestController
@RequestMapping("/api")
public class IAdminController {
	@Autowired
	private IAdminServiceImpl dao;
	//Add admin 
	@PostMapping(path="/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)throws AdminAlreadyExistException{
		return dao.addAdmin(admin);
	}
	//Updte Admin based on id
	@PutMapping(path="/updateAdmin/{adminId}")
	public Admin updateAdmin(@RequestBody Admin admin, @PathVariable int adminId)throws NoAdminFoundException{
		return dao.updateAdmin(admin);
	}
	@GetMapping(path="/fetch/admin/{adminId}")
	public Admin getAdminById(@PathVariable int adminId) {
		return dao.getAdminById(adminId);
		
	}
	//remove admin
	@DeleteMapping(path="/removeAdmin/{adminId}")
	public void removeAdmin(@PathVariable int adminId)throws NoAdminFoundException{
		dao.removeAdmin(adminId);
	}
	

	@GetMapping(path="/viewAdmin")
	public List<Admin>viewAllAdmins(){
		return dao.viewAllAdmins();
		
	}
}
