package com.javadoterr.api.service;

import java.util.List;

import com.javadoterr.api.model.Role;
import com.javadoterr.api.model.User;

public interface UserService {
	
	public List<User> userList();
	
	public User findUserById(Long id);
	
	public String addUser(User user);
	
	public String deleteUserById(Long id);
	
	List<Role> roleList();

}
