package com.ap.electronic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.electronic.dtos.ApiResponse;
import com.ap.electronic.dtos.UserDto;
import com.ap.electronic.services.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String userId, @Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(userService.updateUser(userId, userDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
		
		ApiResponse msg = ApiResponse.builder()
							.message("User Deleted")
							.success(true).build();
		
		return new ResponseEntity<ApiResponse>(msg,HttpStatus.OK);

	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {

		return new ResponseEntity<UserDto>(userService.getUserById(userId), HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{email}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
		return new ResponseEntity<UserDto>(userService.getByEmail(email),HttpStatus.OK);
	}
	

}
