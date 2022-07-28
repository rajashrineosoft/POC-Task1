package com.example.demo.services;

import java.util.List;
import com.example.demo.model.UserDetails;
public interface UserService {

	public List<UserDetails> getUser(); //abstract method
	//loose coupling
	
	//public UserDetails getUser(long userId);

	public UserDetails addUser(UserDetails userDetails);

	public UserDetails updateUser(UserDetails userDetails);

	public void deleteUser(int userId);
	List<UserDetails> searchUsers(String query);
	public List<UserDetails> findUserWithSorting(String field);
//	List<UserDetails> searchUser(String query);
	
}
