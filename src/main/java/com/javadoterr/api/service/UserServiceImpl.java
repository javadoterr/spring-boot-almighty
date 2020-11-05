package com.javadoterr.api.service;

import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javadoterr.api.model.Role;
import com.javadoterr.api.model.User;
import com.javadoterr.api.respository.RoleRepository;
import com.javadoterr.api.respository.UserRepository;

@Service
@CacheConfig(cacheNames = {"userCache"})
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	@Cacheable
//	@Cacheable("userCache")
	public List<User> userList() {
		return userRepository.userList();
	}
	
	
	//for paging implementation
	@Override
	@Cacheable
	public Page<User> findAll(Pageable pageable) {
		return this.userRepository.findAll(pageable);
	}

	
	
	

	@Override
	public User findUserById(Long id) {
		Optional<User> optional = userRepository.findById(id);
		
		return optional.get();
	}

	@Override
	@CachePut(key = "#user")
//	@CachePut(value = "userCache", key = "#user")
	public String addUser(User user) {
		String message = "";
		JSONObject jsonObject = new JSONObject();
		try {
			if(user.getId() == null) {
				message = "Added";
			}else {
				message = "Updated";
			}
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			user.setRole(roleRepository.findById(user.getRoleId()).get());
			jsonObject.put("status", "success");
			jsonObject.put("title", message + " Confirmation");
			jsonObject.put("message", userRepository.save(user).getUserName()+" "+message+" successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}

	@Override
	@CacheEvict(allEntries = true)
//	@CacheEvict(value = "userCache", allEntries = true)
	public String deleteUserById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			userRepository.deleteById(id);
			jsonObject.put("message", "User deleted successfully");
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	@Override
	public List<Role> roleList() {
		return roleRepository.findAll();
	}
	
	@Override
	@CacheEvict(allEntries = true)
//	@CacheEvict(value = "userCache", allEntries = true)
	public void refreshCache() {
		
	}

	
}
