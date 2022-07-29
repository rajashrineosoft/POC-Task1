package com.neosoft.poc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.neosoft.poc.Repository.UserRepository;
import com.neosoft.poc.model.UserDetails;

public interface UserService {

	public List<UserDetails> getUser(); 
	
	public UserDetails addUser(UserDetails userDetails);

	public UserDetails updateUser(UserDetails userDetails);

	public void deleteUser(int userId);
	
	List<UserDetails> searchUsers(String query);
	
	public List<UserDetails> findUserWithSorting(String field);

	List<UserDetails> softDeleteUser(int id);

	

}
