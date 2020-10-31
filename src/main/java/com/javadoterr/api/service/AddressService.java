package com.javadoterr.api.service;

import java.util.List;

import com.javadoterr.api.model.Address;

public interface AddressService {
	
	public List<Address> addressList();
	
	public Address findAddressById(Long id);
	
	public String addAddress(Address address);
	
	public String deleteAddressById(Long id);

}
