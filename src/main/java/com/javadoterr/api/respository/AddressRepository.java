package com.javadoterr.api.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.javadoterr.api.model.Address;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long>{
	
	@Query("FROM Address")
	public List<Address> addressList();
	

}
