package com.madhav.userrest.repository.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madhav.userrest.repository.UserRepository;
import com.madhav.userrest.userdao.Post;
import com.madhav.userrest.userdao.User;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/users")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> userList = userRepository.findAll();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@GetMapping(path = "/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {

		User user = userRepository.findById(id).get();
		if (user == null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user = userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);

	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable("id") long id){
		userRepository.deleteById(id);
	}
	
	@GetMapping(path = "/users/{id}/posts")
	public ResponseEntity<List<Post>> getPostsByUser(@PathVariable long id){
		
		Optional<User> optional = userRepository.findById(id);
		
		if(!optional.isPresent()){
			//throw error
			return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
		}
		
		//User user = optional.get();
		return new ResponseEntity<List<Post>>(optional.get().getPost(), HttpStatus.OK);
		
	}

}
