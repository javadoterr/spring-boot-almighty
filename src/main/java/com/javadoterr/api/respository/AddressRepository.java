package com.javadoterr.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javadoterr.api.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
