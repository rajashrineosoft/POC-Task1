package com.neosoft.poc.controller;

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

import com.neosoft.poc.Repository.UserRepository;
import com.neosoft.poc.model.UserDetails;
import com.neosoft.poc.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	    @Autowired(required=true)
		private UserService userService;
		
	    @Autowired
	    private UserRepository userRepository;
	    
	   // Save user into database
		@PostMapping("/addUser")
		public UserDetails addUser(@Valid @RequestBody UserDetails newUser) {
			return userService.addUser(newUser);
		}
		
		 // Fetch all users from database
		@GetMapping("/getAllUserDetails")
		public Iterable<UserDetails> getUser() {
			return userService.getUser();
		}
	   //Update existing user 
		@PutMapping("/updateUser/{id}")
		public UserDetails updateUser(@Valid @RequestBody UserDetails newUser,@PathVariable("id")int id) {
			return userService.updateUser(newUser);
		}
		
		//Delete user based on id
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
		
		//Search user based on firstName, lastName, pinCode
		@GetMapping("/searchUser")
		public ResponseEntity<List<UserDetails>> searchUser(@RequestParam(name="query", required = false)String query)
		{
			return ResponseEntity.ok(userService.searchUsers(query));
			
		}
		
		//sort user based on any field
        @GetMapping("/{field}")
		public Iterable<UserDetails> getUserWithSort(@PathVariable String field){
			Iterable<UserDetails>users=userService.findUserWithSorting(field);
			return userService.findUserWithSorting(field);
		}
		
        //soft Delete user 
        @DeleteMapping("/softDeleteUser/{userId}")
        public  String softDeleteUser(@PathVariable ("userId")int userId) {
		 userService.softDeleteUser(userId);
		return  "record deleted successfully...";
		}
}

