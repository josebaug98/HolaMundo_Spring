package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	//private final static Logger LOG = Logger.getLogger("com.example.demo.controller.UserController");
	
	@Autowired
	UserServices userServices;
	
	@GetMapping("getUsers")
	public ResponseEntity <?> getUsers(){
	
		Map<String,Object> response = new HashMap<>();
		
		if(userServices.getUsers().isEmpty()) {
			response.put("Data: ", "No hay información para mostrar.");
		}
		
		else {
		response.put("data",userServices.getUsers());}
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.ACCEPTED);
		
		//return userServices.getUsers();
	
}
	
	@GetMapping("getUserByName/{name}")
	public ResponseEntity <?> getUserByName(@PathVariable String name){
	
		Map<String,Object> response = new HashMap<>();
		
		UserDTO userDTO = userServices.getUserByName(name);
		
		if(userDTO == null) {
			response.put("Data: ", "No hay información para mostrar.");
		}
		
		else {
		response.put("data", userDTO);}
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.ACCEPTED);
		
		//return userServices.getUsers();
	
}
	
	@GetMapping("findByName/{name}")
	public ResponseEntity <?> findByName(@PathVariable String name){
	
		Map<String,Object> response = new HashMap<>();
		
		UserDTO userDTO = userServices.findByName(name);
		
		if(userDTO == null) {
			response.put("Data: ", "No hay información para mostrar.");
		}
		
		else {
		response.put("data", userDTO);}
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.ACCEPTED);
		
		//return userServices.getUsers();
	
}
	@PostMapping("/usuarios")
	public ResponseEntity<?> create(@RequestBody User user ) {
		
		Map<String, Object> response = new HashMap<>();
		
		if(user.getName() != null) {
			response.put("Status: ", "The User was Created Succesfully!");
			response.put("Data: ", user);
		}
		
		else {
			response.put("Status: ", "Add a User, please.");
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	

}
