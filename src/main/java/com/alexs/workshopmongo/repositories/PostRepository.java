package com.alexs.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alexs.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	public List<Post> findAll();

}
