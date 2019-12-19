package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final static Logger LOG = Logger.getLogger("com.example.demo.controller.UserController");
	
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
	

}
