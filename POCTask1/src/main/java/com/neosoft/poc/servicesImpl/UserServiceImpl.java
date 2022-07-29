package com.neosoft.poc.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.neosoft.poc.Repository.UserRepository;
import com.neosoft.poc.model.UserDetails;
import com.neosoft.poc.services.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	 public UserServiceImpl(UserRepository userRepository) {
			super();
			this.userRepository = userRepository;
		}
	 
	/* Method for display users */
	@Override
	public List<UserDetails> getUser() {
		
		List<UserDetails> userList=userRepository.findAll();
		return userList;
	}

	/* Method for Add new user */
	@Override
	public UserDetails addUser(UserDetails newUser) {
		
		return userRepository.save(newUser);
	}

	/* Method for Update user */
	@Override
	public UserDetails updateUser(UserDetails newUser) {
		
		return userRepository.save(newUser);
	}

	/* Method for Delete user */
   @Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
		
	}
   
   /* Method for Search user */
   @Override
	public List<UserDetails> searchUsers(String query) {
		List<UserDetails>users=userRepository.searchUserSQL(query);
		return users;
	}
   
   /* Method for Sort User Data */
   @Override
	public List<UserDetails> findUserWithSorting(String field) {
		
		return userRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

   /* Method for Soft Delete user */
  @Override
	public List<UserDetails>softDeleteUser(int id)
	{
		UserDetails userDetails=userRepository.findById(id).get();
		userDetails.setActive(false);
		userRepository.save(userDetails);
		List<UserDetails>userlist=userRepository.findAll();
		List<UserDetails>list=new ArrayList<>();
		for(UserDetails user:userlist)
		{
			if(user.isActive()==true)
			{
				list.add(userDetails);
			}
		}
		return list;
	}
	
	
}