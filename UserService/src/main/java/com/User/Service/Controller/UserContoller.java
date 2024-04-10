package com.User.Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.User.Service.Entitys.User;
import com.User.Service.Services.UserServices;

@RestController
@RequestMapping("/users")
public class UserContoller {
	@Autowired
	private UserServices userServices;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser  = userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser );
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId)
	{
		User user=userServices.getUser(userId);
		return ResponseEntity.ok(user);
		
	}
	@GetMapping
	public ResponseEntity<List<User>> getUser()
	{
		List<User> alluser=userServices.getAllUser();
		return ResponseEntity.ok(alluser);
	}
}
