package com.ap.electronic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	private String userId;
	@Column(name = "user_name")
	private String username;
	@Column(name = "user_email", unique = true)
	private String email;
	private String password;
	private String gender;
	private String about;
	private String imageName;

}
