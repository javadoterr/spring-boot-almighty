package com.javadoterr.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javadoterr.api.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
