package com.takeo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.entity.User;
import com.takeo.repo.UserRepo;
import com.takeo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo daoImpl;

	@Override
	public User createUser(User user) {
		User u = daoImpl.save(user);
		return u;

	}

	@Override
	public User readUser(Long uid) {
		User user = daoImpl.findById(uid).get();
		return user;
	}

	@Override
	public User readUser(String uname) {
		User users = daoImpl.findByUname(uname);
		if (users != null) {
			return users;
		}
		return null;
	}

	@Override
	public List<User> readUsers() {
		List<User> users = daoImpl.findAll();
		return users;
	}

	@Override
	public User updateUser(User user) {
		User existingUser = daoImpl.findById(user.getUid()).get();
		if (existingUser != null) {
			existingUser.setFname(user.getFname());
			existingUser.setLname(user.getLname());
			existingUser.setEmail(user.getEmail());
			existingUser.setUname(user.getUname());
			User updatedUsr = daoImpl.save(existingUser);
			return updatedUsr;
		}
		return null;
	}

	@Override
	public boolean deleteUser(Long uid) {
		User existingUser = daoImpl.findById(uid).get();
		if (existingUser != null) {
			daoImpl.deleteById(uid);
			return true;
		}
		return false;
	}

}
