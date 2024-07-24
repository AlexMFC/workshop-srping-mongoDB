package com.alexs.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexs.workshopmongo.domain.User;
import com.alexs.workshopmongo.dto.UserDTO;
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
		User user = userOpt.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
		if (user== null) {
			throw new ObjectNotFoundException(String.format("Object %s not found", id));
		}
		return user;
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		Optional<User> user = repository.findById(id);
		
		repository.delete(user.get());;
	}
	
	
	public User update(User user, String id) {
		Optional<User> userOpt = repository.findById(user.getId());
		User userObj = userOpt.get();
		updateData(userObj, user);
		return repository.save(userObj); 
	}

	private void updateData(User userObj, User user) {
		userObj.setName(user.getName());
		userObj.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
}



