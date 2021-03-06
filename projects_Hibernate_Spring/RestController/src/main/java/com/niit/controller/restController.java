package com.niit.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.niit.crudhibernatespring.service.UserService;
import com.niit.crudhibernatespring.model.*;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class restController {

		@Autowired
		UserService userService;
		
		@GetMapping("/")
		public ResponseEntity<List<User>> getUserList()
		{
			userService.getUserList();
			return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.OK);
		}
		@GetMapping("/{userId}")
		public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
			return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);		
		}
		@PostMapping
		public ResponseEntity<Void> adduser(@RequestBody User user) {
			userService.addUser(user);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		@PutMapping
		public ResponseEntity<Void> updateUser(@RequestBody User user) {
			
			userService.updateRecord(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		@DeleteMapping
		public ResponseEntity<Void> deleteUser(@RequestBody User user) {
			
			userService.deleteRecord(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

}
