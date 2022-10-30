package com.project.bank.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.project.bank.model.Users;

public interface UserRepository extends ReactiveMongoRepository<Users, Integer> {

}
