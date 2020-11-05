package com.javadoterr.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javadoterr.api.model.User;
import com.javadoterr.api.service.UserService;
import com.javadoterr.api.utils.ErrorUtils;
import com.javadoterr.api.utils.MethodsUtils;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(path = "login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if(error != null) {
			model.addAttribute("error", "Your username and password is invalid!");
		}
		if(logout != null) {
			model.addAttribute("message", "You have been logged out successfully!");
		}
		return "login";
	}
	
	
	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public String userForm(Model model) {
		
		model.addAttribute("userForm", new User());
		model.addAttribute("roles", service.roleList());
		
		return "user/form";
	}
	
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("userForm", service.findUserById(id));
		model.addAttribute("roles", service.roleList());
		
		return "user/form";
	}
	
	
	
	@RequestMapping(path = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public String addUser(@Valid @RequestBody User user, BindingResult result) {
		if(result.hasErrors()) {
			return ErrorUtils.customErrors(result.getAllErrors());
		}else {
			return this.service.addUser(user);
		}
	}
	
	
	@RequestMapping(path = "/list/{id}", method = RequestMethod.GET)
	public User findUser(@PathVariable("id") Long id) {
		return this.service.findUserById(id);
	}
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public String userList(Model model, Pageable pageable) {
		Page<User> pages = this.service.findAll(pageable);
		model.addAttribute("users", pages.getContent());
		MethodsUtils.pageModel(model, pages);
		return "/user/list";
	}
	
	@RequestMapping(path = "/refresh", method = RequestMethod.GET)
	public String refreshCache(Model model, Pageable pageable) {
		this.service.refreshCache();
		Page<User> pages = this.service.findAll(pageable);
		model.addAttribute("users", pages.getContent());
		MethodsUtils.pageModel(model, pages);
		return "/user/list";
	}
	
	@RequestMapping(path = "/delete/{id}", method =  RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public String deleteUser(@PathVariable("id") Long id) {
		 
		 return this.service.deleteUserById(id);
	}
	

}
