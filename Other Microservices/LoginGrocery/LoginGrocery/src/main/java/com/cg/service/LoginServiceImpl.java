package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Login;
import com.cg.repository.LoginRepository;



@Service(value = "service")
public class LoginServiceImpl implements LoginService {	
	
	@Autowired
	private LoginRepository repos;
	
	@Override
	public Login addCredential(Login login) {
		return repos.save(login);
		}

	@Override
	public List<Login> getAll() {
		return repos.findAll();
	}

}
