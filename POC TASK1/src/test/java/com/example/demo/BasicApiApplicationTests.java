package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.UserDetails;

@SpringBootTest
class BasicApiApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	@Test
	@Order(1)
 public void testSaveNewUser() throws ParseException {
	UserDetails userDetails=new UserDetails();
	userDetails.setId(1);
	userDetails.setFirstName("rajashri");
	userDetails.setLastName("chavan");
	userDetails.setPinCode(1234);
	userDetails.setDateOfBirth("12/12/2022");
	userDetails.setJoiningDate("11/11/2022");
	userRepository.save(userDetails);
	assertNotNull(userRepository.findById(1).get());
	
	}
	
   @Test
   @Order(2)
   public void testReadAllUserDetails()
   {
	   List<UserDetails>list= userRepository.findAll() ;
	   assertThat(list).size().isGreaterThan(0);
 }
   @Test
   @Order(3)
   public void testSingleUserDetails()
   {
	UserDetails userDetails=userRepository.findById(7).get();
	assertEquals("dev", userDetails.getFirstName());
   }

   @Test
   @Order(4)
   public void testUpdateUser()
   {
	 UserDetails userDetails=  userRepository.findById(5).get();
	   userDetails.setFirstName("Aadu");
	   userRepository.save(userDetails);
	   assertNotEquals("manali", userRepository.findById(5).get().getFirstName());
   }
   @Test
   @Order(5)
   public void testDeleteUser()
 {
	userRepository.deleteById(1);
	assertThat(userRepository.existsById(1)).isFalse();
 }
   
   @Test
   public void sortingByMultipleFields(){
       String sortBy = "dateOfBirth";
       String sortByDesc = "joiningDate";
       String sortDirection = "desc";

       Sort sortBydateOfBirth = sortDirection.equals(Sort.Direction.ASC.name())?
               Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

       Sort sortByjoiningDate = sortDirection.equals(Sort.Direction.ASC.name())?
               Sort.by(sortByDesc).ascending(): Sort.by(sortByDesc).descending();

       Sort groupBySort = sortBydateOfBirth.and(sortByjoiningDate);

       List<UserDetails> users = userRepository.findAll(groupBySort);

       users.forEach((u) ->{
           System.out.println(u);
       });
   }
}


