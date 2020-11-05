package com.javadoterr.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.javadoterr.api.model.Address;

public interface AddressService {
	
	public List<Address> addressList();
	
	Page<Address> findAll(Pageable pageable);
	
	public Address findAddressById(Long id);
	
	public String addAddress(Address address);
	
	public String deleteAddressById(Long id);
	
	public void refreshCache();

}
