package com.alexs.workshopmongo.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexs.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User teste = new User("1", "Teste", "teste@teste.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(teste));
		return ResponseEntity.ok().body(list);
	}
	
}
