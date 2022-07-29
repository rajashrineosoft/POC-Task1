package com.neosoft.poc.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neosoft.poc.model.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails,Serializable>{
	
	
	@Query(value="SELECT * FROM userdetails u WHERE " +
		       "u.firstname LIKE CONCAT('%',:query,'%')" +
				"Or u.lastname LIKE CONCAT('%',:query,'%')" +
		       "Or u.pincode LIKE CONCAT('%',:query,'%')", nativeQuery=true)
	
			List<UserDetails> searchUserSQL(String query);
}
