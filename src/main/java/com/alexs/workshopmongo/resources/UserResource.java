package com.alexs.workshopmongo.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexs.workshopmongo.domain.User;
import com.alexs.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}

}
