package com.jj.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import main.java.spring.mongo.model.JJUser;

public interface UserRepository extends MongoRepository<JJUser, String> {

}
