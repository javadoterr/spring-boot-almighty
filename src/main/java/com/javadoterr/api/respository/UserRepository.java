package com.javadoterr.api.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.javadoterr.api.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

//	@Query("FROM User WHERE userName=:userName")
//	public User findByUsername(@Param("userName")String userName);

	public User findByUserName(String userName);
	
	@Query("FROM User")
	public List<User> userList();

}
