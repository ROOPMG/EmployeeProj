package com.Emp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emp.exception.ResourceDBException;
import com.Emp.model.User;
import com.Emp.repository.ILoginRepository;
import com.Emp.service.ILoginService;

@Service

public class ILoginServiceImpl implements ILoginService{

	
	
		private ILoginRepository repository;
	    public User loggedIn = null;
	    @Override
	    public User validateLogin(User user) throws ResourceDBException {
			String email=user.getEmail();
	        String password=user.getPassword();
	        if(!email.contains("@")){
	            //logger.error("Invalid Email");
	            throw new ResourceDBException("Invalid Email");
	        }
	            
	            // Check if user provided valid password

	            if(password.length() < 6) {
	                //logger.error("Password is Invalid");
	                throw new ResourceDBException("Password should be more than 6 characters");
			
		}
				return user;
			
	}

	@Override
	public User logout(User user) {
		user.setEmail(null);
		user.setPassword(null);
		return user;
	}

	@Override
	public User getLogin(String email, String password) {
		// TODO Auto-generated method stub
		
		return  repository.getLogin(email,password);
	}
	 
	
}
