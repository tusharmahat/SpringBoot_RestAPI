package com.takeo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takeo.entity.User;


public interface UserRepo extends JpaRepository<User, Long> {
	 User findByUname(String uname);
	 User  findByEmail(String email);
}
