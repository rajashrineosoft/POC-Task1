package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.UserDetails;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	    @Autowired(required=true)
		private UserService userService;
		
	    @Autowired
	    private UserRepository userRepository;
	    
		@PostMapping("/addUser")
		public UserDetails addUser(@Valid @RequestBody UserDetails newUser) {
			return userService.addUser(newUser);
		}
		

		@GetMapping("/getAllUserDetails")
		public Iterable<UserDetails> getUser() {
			return userService.getUser();
		}
		
		@PutMapping("/updateUser/{id}")
		public UserDetails updateUser(@Valid @RequestBody UserDetails newUser,@PathVariable("id")int id) {
			return userService.updateUser(newUser);
		}
		
		@DeleteMapping("/DeleteUser/{userById}")
		public ResponseEntity<HttpStatus>  deleteUser( @RequestBody UserDetails newUser,@PathVariable ("userById")int userById)
		{try
		{
			userService.deleteUser(userById);
			return new ResponseEntity<>(HttpStatus.OK);
			// return "record deleted successfully....";
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
		public UserController(UserService userService) {
			super();
			this.userService = userService;
		}
		@GetMapping("/searchUser")
		public ResponseEntity<List<UserDetails>> searchUser(@RequestParam(name="query", required = false)String query)
		{
			return ResponseEntity.ok(userService.searchUsers(query));
			
		}
@GetMapping("/{field}")
		
		public Iterable<UserDetails> getUserWithSort(@PathVariable String field){
			Iterable<UserDetails>users=userService.findUserWithSorting(field);
			return userService.findUserWithSorting(field);
		}
		
		

//		@GetMapping("/search")
//		public ResponseEntity<List<UserRepository>>getUserByfirstName(@RequestParam String firstName){
//			return new ResponseEntity<List<UserRepository>>(userRepository.findByfirstName(firstName),
//					HttpStatus.OK);
//			
//		}
		
//create userDetails constructor
//		public UserController(UserService userService) {
//			
//			this.userService = userService;
//		}
//		@GetMapping("/searchUser")
//		public ResponseEntity<List<UserDetails>> searchUser(@RequestParam(name="query", required = false)String query)
//		{
//			return ResponseEntity.ok(userService.searchUser(query));
//			
//		}
		
}	

