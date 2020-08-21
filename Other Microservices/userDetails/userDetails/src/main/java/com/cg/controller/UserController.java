
package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.User;
import com.cg.repository.UserRepository;
import com.cg.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	public UserService service;
	@Autowired
	public UserRepository repo;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping(path = "/User")
	public List<User> retrieveAllUsers() {
		System.out.println("Inside retrieveAllUsers method of UserController");
		return service.findAll();
	}

	@PostMapping(path = "/User/add")
	User addUser(@RequestBody User user) {
		System.out.println("inside addUser");
		return service.addUser(user);
	}

	@GetMapping(path = "/User/{userId}")
	User retrieveByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);
	}

	@DeleteMapping(path = "/User/delete/{userId}")
	void deleteUser(@PathVariable int userId) {
		service.deleteUser(userId);
	}
//	@DeleteMapping(path = "/delete/{id}")
//	public List<Product> delete(@PathVariable int id) {
//		System.out.println("Inside delete() of Controller");
//		repository.deleteById(id);
//		return repository.findAll();
//	}
	@PutMapping(path = "/User/updatemob/{userId}/mobileno/{mobile}")
	public User updateMobileNo(@PathVariable("userId") int userId, @PathVariable("mobile") String mobile) {
		User user = service.updateMobile(userId, mobile);
		return user;
	}

	@PutMapping(path = "/User/updateaddress/{userId}/address/{address}")
	public User updateAddress(@PathVariable("userId") int userId, @PathVariable("address") String address) {
		User user = service.updateAddress(userId, address);
		return user;
	}

//	@PutMapping(path = "/User/update")
//	public String updateUser(@RequestBody User user) {
//		service.updateUser(user);
//		return "User updated";
//	}
	@PutMapping(path="/update/{userId}")
	public void updateUser(@Valid @PathVariable int userId,@RequestBody User user) {
		 service.updateUser(user);
	//	Product prod = 	repository.save(product);
//		User usr=repo.save(user);
//		return usr;
	}

	@GetMapping(path = "/User/findbyemail/{email}")
	User retrieveByemail(@PathVariable("email") String email) {
		return service.findByemail(email);
	}

}
