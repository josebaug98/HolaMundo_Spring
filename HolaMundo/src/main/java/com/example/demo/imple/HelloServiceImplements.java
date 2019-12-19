package com.example.demo.imple;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.services.HelloServices;

@Service
public class HelloServiceImplements implements HelloServices{
	private final static Logger LOG = Logger.getLogger("com.example.demo.imple.HelloServiceImplements");

	@Override
	public ResponseEntity<?> getHello() {
		
		Map<String,Object> respuesta = new HashMap<>();
		
		LOG.info("Hola Mundo desde SpringBoot - getHello");
		respuesta.put("respuesta","Hola Mundo desde SpringBoot - Se ha implementado getHello - 202Accepted");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.ACCEPTED);
	}

}
