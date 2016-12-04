package com.ec.htracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public UserLoginService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	
	public boolean authenticateEncriptedUserData(String userName, String encriptedPassword) {
		boolean userExists = false;
		int rowcount = jdbcTemplate.queryForObject("select count(*) from users " + " where username = ? and password = ?",
				Integer.class, userName, encriptedPassword);
		if (rowcount == 1) {
			userExists = true;
		}
		return userExists;
	}	
}
