package com.ap.electronic.repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.electronic.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	
	public User findByEmail(String email);
	
	//public List<User> findByNameContaning(String keyword);
	
}
