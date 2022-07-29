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

import com.neosoft.poc.Repository.UserRepository;
import com.neosoft.poc.model.UserDetails;

@SpringBootTest
class BasicApiApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	/* Test case for Save User (Post method) */
	@Test
	@Order(1)
 public void testSaveNewUser() throws ParseException {
	UserDetails userDetails=new UserDetails();
	userDetails.setId(19);
	userDetails.setFirstName("mayur");
	userDetails.setLastName("chavan");
	userDetails.setPinCode(1234);
	userDetails.setDateOfBirth("12/12/2022");
	userDetails.setJoiningDate("11/11/2022");
	userRepository.save(userDetails);
	assertNotNull(userRepository.findById(19).get());
	
	}
	
	/* Test case for Fetch User (Get method) */
   @Test
   @Order(2)
   public void testReadAllUserDetails()
   {
	   List<UserDetails>list= userRepository.findAll() ;
	   assertThat(list).size().isGreaterThan(0);
 }
   
	/* Test case for Fetch Single User (Get method) */
   @Test
   @Order(3)
   public void testSingleUserDetails()
   {
	UserDetails userDetails=userRepository.findById(24).get();
	assertEquals("reya", userDetails.getFirstName());
   }
   
   /* Test case for search User  */
   @Test
   @Order(5)
   public void testSearchUserDetails()
   {
	UserDetails userDetails=userRepository.findById(22).get();
	assertEquals("manali", userDetails.getFirstName());
   }
   
	/* Test case for Update User (Put method) */
   @Test
   @Order(4)
   public void testUpdateUser()
   {
	 UserDetails userDetails=  userRepository.findById(5).get();
	   userDetails.setFirstName("Aadu");
	   userRepository.save(userDetails);
	   assertNotEquals("manali", userRepository.findById(5).get().getFirstName());
   }
   
	/* Test case for Delete User (Delete method) */
   @Test
   @Order(5)
   public void testDeleteUser()
 {
	userRepository.deleteById(19);
	assertThat(userRepository.existsById(19)).isFalse();
 }
	
   /* Test case for Sort User  */
   @Test
   @Order(6)
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


