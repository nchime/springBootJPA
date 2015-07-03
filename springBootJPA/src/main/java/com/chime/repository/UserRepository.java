package com.chime.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.chime.domain.User;
import com.datastax.driver.core.querybuilder.Insert;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
//	 List<User> findByLastname(String lastname);
	 
//	 @Query("select count(*) from user u where u.user_name = '한%'")
//	 Long countByUsernameSQL(@Param("userName") String userName);
	
	
//	@Query("select id, regi_date from user where user_name=?1")
//    public List<User> findByUsernameSQL(@Param(username) String username);
	
	
	public User findById(Long id);
	
	public List<User> findByUserName(String userName);
//	public List<User> findByUserId(Integer userid);
	
	
	// native Query를 통한 결과 출력
	@Query(value="select * from user u where u.username=?1", nativeQuery = true)
    public List<User> findByUsernameSQL(String username);
	
	
	
	// native Query를 통한 데이터 입력
	// 	@Query(value="insert into user(user_id, username, passwd, regi_date) value(?1, ?2, ?3, curdate())", nativeQuery = true)

//	@Query(value="insert into user(user_id, username, passwd, regi_date) value(?1, ?2, ?3, ?4)", nativeQuery = true)
//    public void insertDummyData(String userid, String username, String passwd, Date dateStr);
	
	
	

}
