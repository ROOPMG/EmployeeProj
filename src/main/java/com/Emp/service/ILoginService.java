package com.Emp.service;

import com.Emp.exception.ResourceDBException;
import com.Emp.model.User;

public interface ILoginService {
	public User validateLogin(User user) throws ResourceDBException;

	public User logout(User user);
	
	public User getLogin(String email,String password);
}

