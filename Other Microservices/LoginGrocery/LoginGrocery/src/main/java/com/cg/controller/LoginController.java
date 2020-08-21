package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Login;
import com.cg.service.LoginServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
//@Api(value = "LoginController using logger and swagger")
public class LoginController {

	@Autowired
	private LoginServiceImpl service;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@PostMapping(path = "/AddLogin")

//	@ApiOperation(value = "retrieveLimitsFromConfigurations", nickname = "retrieveLimitsFromConfigurations")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Login.class),
//			@ApiResponse(code = 500, message = "Failure", response = Login.class) })

	Login addCredential(@RequestBody Login login) {
		return service.addCredential(login);
	}

	@RequestMapping("/getall")
//	@ApiOperation(value = "retrieveLimitsFromConfigurations", nickname = "retrieveLimitsFromConfigurations")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Login.class),
//			@ApiResponse(code = 500, message = "Failure", response = Login.class) })
	
	public List<Login> getAll() {
		return service.getAll();
	}
}
