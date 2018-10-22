package com.madhav.userrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhav.userrest.userdao.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long > {

	//public User getUserById(long id);
	
}
