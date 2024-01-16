package com.ap.electronic.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


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
	
	
	public UserDto() {
		// 
	}


	public UserDto(String userId,
			@NotBlank(message = "username should be not null!!") @Size(min = 3, max = 20, message = "Enter correct username!!") @NotEmpty(message = "username should not be null") String username,
			@Email(message = "enter correct email") String email,
			@NotEmpty(message = "password should not be empty") String password,
			@Size(min = 4, max = 6, message = "enter correct gender") String gender,
			@NotBlank(message = "about should not be blank") String about, String imageName) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.about = about;
		this.imageName = imageName;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", about=" + about + ", imageName=" + imageName + "]";
	}
	
	
}
