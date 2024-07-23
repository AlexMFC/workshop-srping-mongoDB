package com.alexs.workshopmongo.dto;

import com.alexs.workshopmongo.domain.User;

public class UserDTO {
	private String name;
	private String email;

	public UserDTO() {
	}

	public UserDTO(User obj) {
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
