package com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.model.Withdraw;
import com.project.bank.repository.UserRepository;
import com.project.bank.repository.WithdrawRepository;
import reactor.core.publisher.Mono;
@RestController
public class WithdrawController {
	

	@Autowired
	private WithdrawRepository with_repo;
	
	@Autowired
	private UserRepository user_repo;
	
	@PutMapping("/withdraw/{accountNo}/{amount}")
	public Mono<Withdraw> withdrawAmt(@PathVariable int accountNo,@PathVariable int amount){
		user_repo.findAll().filter(user -> user.getAccountNo()==(accountNo)).doOnNext(user ->{
			user.setBalance(user.getBalance() -amount);
			System.out.println(user);
		}).flatMap(user_repo::save).blockFirst();
		return with_repo.save(new Withdraw(accountNo,amount));
		
	}
}
