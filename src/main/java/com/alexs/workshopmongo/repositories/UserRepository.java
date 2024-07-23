package com.alexs.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alexs.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
	public List<User> findAll();

}
