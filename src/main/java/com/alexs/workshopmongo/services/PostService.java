package com.alexs.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexs.workshopmongo.domain.Post;
import com.alexs.workshopmongo.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> postOpt = repository.findById(id);
		return postOpt.orElseThrow();
	}
	
	public List<Post> findByTitle(String str){
		return repository.findByTitleContaining(str);
	}
	
}



