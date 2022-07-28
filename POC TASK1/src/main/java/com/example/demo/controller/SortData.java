package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.UserDetails;

@RestController
public class SortData {
	
	UserRepository userRepository;

	@GetMapping("/SortDataByDateOfBirth")
	public List<UserDetails> getAllByCols (@RequestParam String field1, @RequestParam String field2) {
		return userRepository.findAll(Sort.by(Direction.DESC, field1, field2));
	}
	
	@GetMapping("/SortDataByDateOfJoining")
	public List<UserDetails> getAllByDirections (@RequestParam String field1, @RequestParam String field2) {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(Direction.DESC, field1));
		orders.add(new Order(Direction.ASC, field2));
		return userRepository.findAll(Sort.by(orders));
}
}
