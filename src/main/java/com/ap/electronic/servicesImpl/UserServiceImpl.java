package com.ap.electronic.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.electronic.dtos.UserDto;
import com.ap.electronic.entities.User;
import com.ap.electronic.exception.ResourceNotFoundException;
import com.ap.electronic.repositeries.UserRepository;
import com.ap.electronic.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {

		String uId = UUID.randomUUID().toString();
		userDto.setUserId(uId);

		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		User user1 = userRepository.save(user);

		UserDto newDto = new UserDto();
		BeanUtils.copyProperties(user1, newDto);

		return newDto;
	}

	@Override
	public UserDto updateUser(String userId, UserDto userDto) {

		User user = userRepository.findById(userId).get();
		
		if (user != null) {

			if (userDto.getUsername() != null && userDto.getUsername() != "") {
				user.setUsername(userDto.getUsername());
			}
			if (userDto.getEmail() != null && userDto.getEmail() != "") {

				user.setEmail(userDto.getEmail());
			}
			if (userDto.getGender() != null && userDto.getGender() != "") {

				user.setGender(userDto.getGender());
			}
			if (userDto.getPassword() != null && userDto.getPassword() != "") {

				user.setPassword(userDto.getPassword());
			}
			if (userDto.getAbout() != null && userDto.getAbout() != "") {

				user.setAbout(userDto.getAbout());
			}
			if (userDto.getImageName() != null && userDto.getImageName() != " ") {

				user.setImageName(userDto.getImageName());
			}
		} else {
			throw new RuntimeException("No such user found with given userId");
		}
		userRepository.save(user);

		UserDto userDto2 = new UserDto();
		BeanUtils.copyProperties(user, userDto2);
	
		return userDto2;
	}

	@Override
	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public UserDto getUserById(String userId) {

		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No such user found"));
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> user = userRepository.findAll();
		
		List<UserDto> userDto1 = new ArrayList<UserDto>();
		for (User u : user) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(u, userDto);
			userDto1.add(userDto);
		}
		return userDto1;
	}

	@Override
	public UserDto getByEmail(String email) {
		User user = userRepository.findByEmail(email);
		UserDto userDto = new UserDto();
		if (user != null) {
			BeanUtils.copyProperties(user, userDto);
		} else {
			throw new ResourceNotFoundException("no such user found by given mail id");
		}
		return userDto;
	}

}
