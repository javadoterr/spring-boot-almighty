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

import com.javadoterr.api.model.Address;
import com.javadoterr.api.service.AddressService;
import com.javadoterr.api.service.UserService;
import com.javadoterr.api.utils.ErrorUtils;
import com.javadoterr.api.utils.MethodsUtils;

@Controller
@RequestMapping(value = "/address")
public class AddressController {

	private AddressService service;
	private UserService userService;

	@Autowired
	public AddressController(AddressService service, UserService userService) {
		this.service = service;
		this.userService = userService;
	}
	
	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public String addressForm(Model model) {
		
		model.addAttribute("addressForm", new Address());
		model.addAttribute("users", userService.userList());
		return "address/form";
	}
	
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String editAddress(@PathVariable Long id, Model model) {
		model.addAttribute("addressForm", service.findAddressById(id));
		model.addAttribute("users", userService.userList());
		
		return "address/form";
	}

	@RequestMapping(path = "/list")
	public String addressList(Model model, Pageable pageable) {
		Page<Address> pages = this.service.findAll(pageable);
		model.addAttribute("addresses", pages.getContent());
		MethodsUtils.pageModel(model, pages);
		return "/address/list";
	}
	
	
	
	@RequestMapping(path = "/refresh", method = RequestMethod.GET)
	public String refreshCache(Model model, Pageable pageable) {
		this.service.refreshCache();
		Page<Address> pages = this.service.findAll(pageable);
		model.addAttribute("addresses",pages.getContent());
		MethodsUtils.pageModel(model, pages);
				
		return "/address/list";
	}

	@RequestMapping(path = "/list/{id}")
	public Address findOne(@PathVariable("id") Long id) {
		return service.findAddressById(id);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public String addAddress(@Valid @RequestBody Address address, BindingResult result) {
		if(result.hasErrors()) {
			return ErrorUtils.customErrors(result.getAllErrors());
		}else {
			return service.addAddress(address);
		}
		
	}

	@RequestMapping(path = "/delete/{id}", method =  RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public String deleteAddress(@PathVariable("id") Long id) {		 
		 return service.deleteAddressById(id);
	}

}
