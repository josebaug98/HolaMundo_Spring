package com.example.demo.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;


@Service
public class UserServiceImplements implements UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	

}
