package com.project.bank.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.project.bank.model.Withdraw;

@Repository
public interface WithdrawRepository extends ReactiveMongoRepository<Withdraw, Integer> {

}
