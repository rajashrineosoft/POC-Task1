package com.example.demo.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.UserDetails;
import com.example.demo.services.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDetails> getUser() {
		
		List<UserDetails> userList=userRepository.findAll();
		return userList;
	}

	@Override
	public UserDetails addUser(UserDetails newUser) {
		
		return userRepository.save(newUser);
	}

	@Override
	public UserDetails updateUser(UserDetails newUser) {
		
		return userRepository.save(newUser);
	}


//	@Override
//	public void deleteUser(Long parseLong) {
//		UserDetails entity=userRepository.getOne(parseLong);
//		userRepository.delete(entity);
//	}

//	@Override
//	public UserDetails getUser(long userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
   @Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
		
	}
   public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
   @Override
	public List<UserDetails> searchUsers(String query) {
		List<UserDetails>users=userRepository.searchUserSQL(query);
		return users;
	}
   @Override
	public List<UserDetails> findUserWithSorting(String field) {
		
		return userRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

   //constructor
//	public UserServiceImpl(UserRepository userRepository) {
//	this.userRepository = userRepository;
//}
//	@Override
//	public List<UserDetails> searchUser(String query) {
//		List<UserDetails>users=userRepository.searchUserSQL(query);
//		return users;
//		
//	}

	
	
}