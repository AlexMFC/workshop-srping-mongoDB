package com.alexs.workshopmongo.resources;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alexs.workshopmongo.domain.User;
import com.alexs.workshopmongo.dto.UserDTO;
import com.alexs.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User userObj = service.findByID(id);
		return ResponseEntity.ok().body(new UserDTO(userObj));

		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto){
		User user = service.fromDTO(userDto);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<User> update(@PathVariable String id, @RequestBody UserDTO userDto){
		User user = service.fromDTO(userDto);
		user.setId(id);
		service.update(user, id);
		return ResponseEntity.noContent().build();
	}
}
