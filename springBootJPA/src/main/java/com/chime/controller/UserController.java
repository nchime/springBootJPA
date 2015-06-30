package com.chime.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chime.domain.ReturnMsg;
import com.chime.domain.User;
import com.chime.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	
	private ReturnMsg returnMsg; 
	
	String retMsg = "";

	// @Autowired
	// private User user;

	@RequestMapping
	@ResponseBody
	public String index() {
		return "Hello Spring Data JPA";
	}

	@RequestMapping("/users")
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	/**
	 * 데이터 create 
	 * 
	 * @return
	 */
	@RequestMapping("/useradd")
	public ReturnMsg addUser() {

		User user = new User();
		Date date = new Date();
		
		returnMsg = new ReturnMsg(); 

		user.setUserId("test1");
		user.setRegiDate(date.toString());
		user.setPassWD("test1");
		user.setUserName("곽채화");

		
		user = userRepository.saveAndFlush(user);
		
		returnMsg.setStatusCode(100);
		returnMsg.setMsg(Long.toString(user.getId()) + " 값을 추가하였습니다.");  
		retMsg = user.getId() + " 값을 추가하였습니다.";

		return returnMsg;
	}

	/**
	 * 데이터 delete
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userdel/{useridx}", method = RequestMethod.GET)
	public ReturnMsg delUser(@PathVariable Long useridx) {

		LOGGER.debug("data delete num : " + useridx);
		
		returnMsg = new ReturnMsg();

		if (userRepository.exists(useridx)) {
			returnMsg.setStatusCode(100);
			returnMsg.setMsg(useridx.toString() + " 값을 삭제하였습니다");  
		} else {
			returnMsg.setStatusCode(404);
			returnMsg.setMsg(" 삭제할 데이터가 없습니다.");  
		}

		return returnMsg;

	}

	/*
	 * @RequestMapping("add/{sosiId}") public Schedule addSchedule(@PathVariable
	 * Long sosiId, @RequestParam(value="program") String program) { Sosi sosi =
	 * userRepository.findOne(sosiId); Schedule schedule =
	 * userRepository.save(new Schedule(sosi, program));
	 * 
	 * return schedule; }
	 */

}
