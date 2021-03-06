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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javadoterr.api.model.Role;
import com.javadoterr.api.model.User;
import com.javadoterr.api.respository.RoleRepository;
import com.javadoterr.api.respository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public List<User> userList() {
		return userRepository.userList();
	}

	// for paging implementation
	@Override
	public Page<User> findAll(Pageable pageable) {
		return this.userRepository.findAll(PageRequest.of(pageable.getPageNumber() - 1, 3));
	}

	@Override
	public User findUserById(Long id) {
		Optional<User> optional = userRepository.findById(id);

		return optional.get();
	}

	@Override
	public String addUser(User user) {
		String message = "";
		JSONObject jsonObject = new JSONObject();
		try {
			if (user.getId() == null) {
				message = "Added";
			} else {
				message = "Updated";
			}
			if(user.getProfilePhoto() == null) {
				user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
				user.setRole(roleRepository.findById(user.getRoleId()).get());
			}
			jsonObject.put("status", "success");
			jsonObject.put("title", message + " Confirmation");
			jsonObject.put("message", userRepository.save(user).getUserName() + " " + message + " successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

	@Override
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
	public void refreshCache() {

	}

}
