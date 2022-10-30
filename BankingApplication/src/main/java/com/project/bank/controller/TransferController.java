package com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.model.Transfer;
import com.project.bank.repository.TransferRepository;
import com.project.bank.repository.UserRepository;
import reactor.core.publisher.Mono;

@RestController
public class TransferController {
	
	@Autowired
	private TransferRepository transfer_repo;
	
	@Autowired
	private UserRepository user_repo;
	@PutMapping("/transfer/{accountNo}/{amount}/{aNo}")
	public Mono<ResponseEntity<Transfer>> transferAmt(@PathVariable int accountNo,@PathVariable int amount,@PathVariable int aNo){
		user_repo.findById(accountNo)
		.doOnNext(user -> user.setBalance(user.getBalance() -amount))
		.flatMap(user_repo::save).block();
		user_repo.findById(aNo)
		.doOnNext(user -> user.setBalance(user.getBalance()+amount))
		.flatMap(user_repo::save).block();
		return transfer_repo.save(new Transfer(accountNo,aNo,amount))
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build()); 	
	}
}
