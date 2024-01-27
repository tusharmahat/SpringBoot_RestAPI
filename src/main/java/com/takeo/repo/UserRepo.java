package com.takeo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	 User findByUname(String uname);
	 User  findByEmail(String email);
}
