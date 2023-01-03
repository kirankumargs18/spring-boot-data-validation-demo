package com.kirangs.service;

import java.util.List;

import com.kirangs.dto.UserRequest;
import com.kirangs.entity.User;

public interface UserService {

	User saveUser(UserRequest userRequest);

	List<User> getAllUsers();

	User getUserByUserId(Integer userId);

}
