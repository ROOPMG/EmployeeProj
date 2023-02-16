package com.Emp.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Emp.exception.ResourceDBException;
import com.Emp.model.User;
import com.Emp.repository.ILoginRepository;
import com.Emp.service.ILoginService;

@RestController
@RequestMapping("/api/users")
public class ILoginController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(ILoginController.class);
	@Autowired
	private ILoginService service;
	@Autowired
	private ILoginRepository logrepos;
	//login
	@PostMapping(path="/validateUser")
	public ResponseEntity<User> validateLogin(@RequestBody User user)throws ResourceDBException{
		logger.info("User login Success");
		return new ResponseEntity<User>(service.validateLogin(user),HttpStatus.OK);
	}

	
	@GetMapping(path="/logout/{userid}")
	public User logout(@PathVariable int userid) {
		
		User u=logrepos.findById(userid).get();
		logger.info("User logout successfully");
		return service.logout(u);
		//return null;
}
		
	@GetMapping(path="user/login/{email}/{password}")
	public User getLogin(@PathVariable String email,@PathVariable String password) {
		return service.getLogin(email, password);
	}
	
	
}


//User u=logrepos.findById(userid).get();
//logger.info("User logout successfully");
//return service.logout(u);
