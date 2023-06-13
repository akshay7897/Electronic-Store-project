package com.ap.electronic.services;

import java.util.List;

import com.ap.electronic.dtos.UserDto;

public interface UserService {

	// create
	public UserDto createUser(UserDto userDto);

	// update
	public UserDto updateUser(String userId, UserDto userDto);

	// delete
	public void deleteUser(String userId);

	// get user by id
	public UserDto getUserById(String userId);

	// getall
	public List<UserDto> getAllUsers();
	
	//get by email
	
	public UserDto getByEmail(String email);

	// search

}
