package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByName(String name);
	
	@Query("select user from User user where user.name=?1 ")// Nombre del Modelo "User"
	public User getUserByName(String name);
	
	//public User addUser(User user);
	

}
