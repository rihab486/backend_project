package net.javaguides.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;


@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserRepository userRepository;
    // get all user
	@GetMapping("/user")
	public List<User> getAllEmployees(){
		return userRepository.findAll();
	}
	// (post) create
		@PostMapping("/user/new")
		public User createUser(@RequestBody User u) {
			return userRepository.save(u);
		}
		//get user by id restapi
		@GetMapping("/user/new1/{id}")
		public ResponseEntity<User> getUserById(@PathVariable Integer id) {
			User u = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
			return ResponseEntity.ok(u);
		}
		//
		@PutMapping("/user/{id}")
		public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User UserDetails){
			User u = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
			
			u.setCreationDate(UserDetails.getCreationDate());
			u.setLastUpdateDate(UserDetails.getLastUpdateDate());
			u.setNom(UserDetails.getNom());
			u.setPrenom(UserDetails.getPrenom());
			u.setAdresse(UserDetails.getAdresse());
			u.setNumtel(UserDetails.getNumtel());
			u.setEmail(UserDetails.getEmail());
			u.setPassword(UserDetails.getPassword());
			
			User updatedUser = userRepository.save(u);
			return ResponseEntity.ok(updatedUser);
		}
		// delete user restAPI
		@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id){
			User u = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
			userRepository.delete(u);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
}
}
