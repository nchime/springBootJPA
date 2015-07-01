package com.chime.repository;

import java.util.List;

import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chime.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
//	 List<User> findByLastname(String lastname);
	 
//	 @Query("select count(*) from user u where u.user_name = '한%'")
//	 Long countByUsernameSQL(@Param("userName") String userName);
	
	
//	@Query("select id, regi_date from user where user_name=?1")
//    public List<User> findByUsernameSQL(@Param(username) String username);
	
	
	public User findById(Long id);
	
	public User findByUserName(String userName);

}
