package com.javadoterr.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.javadoterr.api.model.Role;
import com.javadoterr.api.model.User;

public interface UserService {
	
	public List<User> userList();
	
	Page<User> findAll(Pageable pageable);
	
	public User findUserById(Long id);
	
	public String addUser(User user);
	
	public String deleteUserById(Long id);
	
	public List<Role> roleList();
	
	public void refreshCache();

}
