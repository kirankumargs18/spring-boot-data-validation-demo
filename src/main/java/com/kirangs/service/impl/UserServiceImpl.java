package com.kirangs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirangs.dto.UserRequest;
import com.kirangs.entity.User;
import com.kirangs.exception.UserNotFoundException;
import com.kirangs.repository.UserRepository;
import com.kirangs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(UserRequest userRequest) {

		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setMobile(userRequest.getMobile());
		user.setGender(userRequest.getGender());
		user.setAge(userRequest.getAge());
		user.setNationality(userRequest.getNationality());

		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> usersList = userRepository.findAll();
		return usersList;
	}

	@Override
	public User getUserByUserId(Integer userId) {

		Optional<User> retrievedUser = userRepository.findByUserId(userId);

		if (retrievedUser.isEmpty()) {
			throw new UserNotFoundException("user not found with id : " + userId);
		}
		return retrievedUser.get();

	}

}
