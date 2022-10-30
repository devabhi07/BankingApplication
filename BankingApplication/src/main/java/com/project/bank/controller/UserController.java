package com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.model.Users;
import com.project.bank.repository.UserRepository;

import reactor.core.publisher.Mono;

@RestController
public class UserController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/insert")
	public Mono<Users> insertData(@RequestBody Users user){
		return repository.save(user);
		
	}
	@GetMapping("viewBalance/{accNo}")
	public Mono<Users> displayBalance(@PathVariable int accNo){
		return repository.findById(accNo);
	}
	
	

}
