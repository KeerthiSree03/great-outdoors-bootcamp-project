package com.capgemini.go.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.go.user.model.UserBean;
@Repository
public interface IUserRepo extends JpaRepository<UserBean, String> {

	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM UserBean c WHERE c.email = :email")
	public boolean existsByEmail(String email);
	
	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM UserBean c WHERE c.phoneNo = :phoneNo")
	public boolean existsByPhoneNo(long phoneNo);

}
