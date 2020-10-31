package com.javadoterr.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javadoterr.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	@Query("FROM User WHERE userName=:userName")
//	public User findByUsername(@Param("userName")String userName);

	public User findByUserName(String userName);

}
