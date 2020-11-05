package com.javadoterr.api.service;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javadoterr.api.model.Address;
import com.javadoterr.api.model.User;
import com.javadoterr.api.respository.AddressRepository;
import com.javadoterr.api.respository.UserRepository;

@Service
public class AddressServiceImpl implements AddressService{
	
	private AddressRepository repository;
	private UserRepository userRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository repository, UserRepository userRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
	}
	
	

	@Override
	public Address findAddressById(Long id) {
		return repository.findById(id).get();
	}



	@Override
	@Caching(put = {
			@CachePut(value = "addressCache", key = "#address")
	})
//	@CachePut(value = "addressCache", key = "#address")
	public String addAddress(Address address) {
		String message = "";
		JSONObject jsonObject = new JSONObject();
		try {
			if(address.getId() == null) {
				message = "Added";
			}else {
				message = "Updated";
			}
			User user = userRepository.findById(address.getUserId()).get();
			address.setUser(user);
			repository.save(address);
			jsonObject.put("status", "success");
			jsonObject.put("title", message + " Confirmation");
			jsonObject.put("message","Address for "+user.getUserName()+" "+message+ " successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}



	@Override
	@CacheEvict(value = "addressCache", allEntries = true)
	public String deleteAddressById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			 repository.deleteById(id);
			 jsonObject.put("message", "address deleted successfully");
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		 return jsonObject.toString();
	}



	@Override
	@Cacheable("addressCache")
	public List<Address> addressList() {
		
		return repository.addressList();
	}
	
	//for paging implementation
	@Override
	@Cacheable("addressCache")
	public Page<Address> findAll(Pageable pageable) {
		return this.repository.findAll(PageRequest.of(pageable.getPageNumber() - 1, 3));
	}
	
	@Override
	@Caching(evict = {
			@CacheEvict(value = "addressCache", allEntries = true)
	})
//	@CacheEvict(value = "addressCache", allEntries = true)
	public void refreshCache() {
		
	}
	
	
	
	

}
