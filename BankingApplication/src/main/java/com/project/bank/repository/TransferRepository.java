package com.project.bank.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.project.bank.model.Transfer;

@Repository
public interface TransferRepository extends ReactiveMongoRepository<Transfer, Integer> {

}
