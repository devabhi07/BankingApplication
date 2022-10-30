package com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.model.Deposit;
//import com.project.bank.model.Users;
import com.project.bank.repository.DepositRepository;
import com.project.bank.repository.UserRepository;

import reactor.core.publisher.Mono;

@RestController
public class DepositController {
	
	Deposit deposit = new Deposit();

	@Autowired
	private DepositRepository depo_repo;
	
	@Autowired
	private UserRepository user_repo;
	
	@PutMapping("/deposit/{accountNo}/{amount}")
	public Mono<Deposit> depositAmt(@PathVariable int accountNo,@PathVariable int amount){
		user_repo.findAll().filter(user -> user.getAccountNo()==(accountNo)).doOnNext(user ->{
			user.setBalance(user.getBalance()+amount);
			
		}).flatMap(user_repo::save).blockFirst();
		return depo_repo.save(new Deposit(accountNo,amount));
	}
}
