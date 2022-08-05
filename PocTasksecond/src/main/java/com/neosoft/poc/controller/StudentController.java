package com.neosoft.poc.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poc.model.AuthenticationRequest;
import com.neosoft.poc.model.AuthenticationResponse;
import com.neosoft.poc.model.Student;
import com.neosoft.poc.repository.StudentRepository;
import com.neosoft.poc.security.JwtUtil;
import com.neosoft.poc.security.MyUserDetailsService;
import com.neosoft.poc.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
@Autowired
private StudentRepository studentRepository;

@Autowired(required=true)
private StudentService studentService;

@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
		throws Exception {

	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	} catch (BadCredentialsException e) {
		throw new Exception("Incorrect username or password", e);
	}

	final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

	final String jwt = jwtTokenUtil.generateToken(userDetails);

	return ResponseEntity.ok(new AuthenticationResponse(jwt));
}



   //Fetch all students from database
@GetMapping("/getAll")
public ResponseEntity<List<Student> >getStudentData() {

List<Student> students = this.studentService.getStudentData();

return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
}
		
     //Save new Student into database
		 @PostMapping("/insert")
		    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody Student student) {

			Student students = this.studentService.addNewStudent(student);

			return new ResponseEntity<Student>(students, HttpStatus.OK);
		   }
	// Find student by Id
		@GetMapping("/findStudentById/{studentId}")
		public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId) {

			Student student = this.studentService.findByStudentId(studentId);

			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		
		 

}
