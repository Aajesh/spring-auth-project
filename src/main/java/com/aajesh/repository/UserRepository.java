package com.aajesh.repository;

import com.aajesh.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository<UserModel,String> {

    public UserModel findByEmail(String email);
    UserModel findByEmailAndPassword(String email, String password);
}
