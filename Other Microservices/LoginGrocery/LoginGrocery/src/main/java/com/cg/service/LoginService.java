package com.cg.service;

import java.util.List;

import com.cg.model.Login;


public interface LoginService {
	
	Login addCredential(Login login);
	
	public List<Login> getAll();
	
}
