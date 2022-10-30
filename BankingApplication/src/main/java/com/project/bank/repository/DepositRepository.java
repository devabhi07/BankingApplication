package com.project.bank.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.project.bank.model.Deposit;

@Repository
public interface DepositRepository extends ReactiveMongoRepository<Deposit, Integer> {	

}
