package com.ap.electronic.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private String userId;
	@NotBlank(message = "username should be not null!!")
	@Size(min=3,max = 20 ,message = "Enter correct username!!")
	@NotEmpty(message = "username should not be null")
	private String username;
	
	@Email(message = "enter correct email")
	private String email;
	@NotEmpty(message = "password should not be empty")
	private String password;
	@Size(min = 4,max = 6,message = "enter correct gender")
	private String gender;
	@NotBlank(message = "about should not be blank")
	private String about;
	private String imageName;
}
