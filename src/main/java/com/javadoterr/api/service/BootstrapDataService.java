package com.javadoterr.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javadoterr.api.model.Role;
import com.javadoterr.api.model.User;
import com.javadoterr.api.respository.RoleRepository;
import com.javadoterr.api.respository.UserRepository;

@Service
public class BootstrapDataService implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		insertRoles();

		insertUser();

	}

	private void insertRoles() {
		if(roleRepository.findAll().size() == 0) {
			List<Role> roles = new ArrayList<Role>();
			
			Role roleAdmin = new Role();
			roleAdmin.setName("admin");
			roles.add(roleAdmin);
			
			Role roleUser = new Role();
			roleUser.setName("user");
			roles.add(roleUser);
			
			roleRepository.saveAll(roles);
		}
	}

	private void insertUser() {
		if(userRepository.userList().size() == 0) {
			User user  = new User();
			user.setEmail("modi@gmail.com");
			user.setFullName("Narendra Modi");
			user.setMobile("9876543210");
			user.setPassword(new BCryptPasswordEncoder().encode("modi12345"));
			user.setUserId("USR001");
			user.setUserName("modi");
			
			
			userRepository.save(user);
		}
	}

}
