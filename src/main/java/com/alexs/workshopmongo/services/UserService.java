package com.alexs.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions.GetOptions;
import org.springframework.stereotype.Service;

import com.alexs.workshopmongo.domain.User;
import com.alexs.workshopmongo.exceptions.ObjectNotFoundException;
import com.alexs.workshopmongo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findByID(String id) {
		Optional<User> userOpt = repository.findById(id);
		User user = userOpt.orElseThrow(() -> new ObjectNotFoundException(String.format("Object %s not found", id)));
		if (user== null) {
			throw new ObjectNotFoundException(String.format("Object %s not found", id));
		}
		return user;
	}
	
}



