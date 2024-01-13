package com.takeo.service;

import java.util.List;

import com.takeo.entity.User;

public interface UserService {
	User createUser(User user);

	User readUser(Long uid);
	User readUser(String uname);

	List<User> readUsers();

	User updateUser(User user);

	boolean deleteUser(Long uid);

}
