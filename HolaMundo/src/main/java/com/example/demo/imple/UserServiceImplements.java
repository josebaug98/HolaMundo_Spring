package com.example.demo.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;
import com.example.demo.converter.UserConverter;

@Service
public class UserServiceImplements implements UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("UserConverter")
	private UserConverter userConverter;
	
	@Override
	public List<UserDTO> getUsers() {
		return userConverter.UserstoUsersDTO(userRepository.findAll());
		
	}

	@Override
	public UserDTO getUserByName(String name) {
		// TODO Auto-generated method stub
		return userConverter.UsertoUserDTO(userRepository.getUserByName(name));
	}

	@Override
	public UserDTO findByName(String name) {
		// TODO Auto-generated method stub
		return userConverter.UsertoUserDTO(userRepository.findByName(name));
	}
	
	

}
