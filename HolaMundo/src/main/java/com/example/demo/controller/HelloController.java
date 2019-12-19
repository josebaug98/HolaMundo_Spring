


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

import com.example.demo.services.HelloServices;


@RestController
@RequestMapping("/hello")
public class HelloController {
	
	private final static Logger LOG = Logger.getLogger("com.example.demo.controller.HelloController");
	
	@Autowired
	HelloServices helloServices;
	
	@GetMapping("/helloworld")
	public ResponseEntity<?> helloworld(){
		
		Map<String,Object> respuesta = new HashMap<>();
		
		LOG.info("Hola Mundo desde SpringBoot");
		respuesta.put("respuesta","Hola Mundo desde SpringBoot - 202Accepted");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getHello")
		public ResponseEntity <?> getHello(){
		
		return helloServices.getHello();
		
	}

}