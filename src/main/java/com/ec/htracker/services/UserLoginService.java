package com.ec.htracker.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ec.htracker.model.User;
import com.ec.htracker.model.UserRowMapper;

@Service
public class UserLoginService {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserLoginService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User authenticateEncriptedUserData(String userName, String encriptedPassword) {

		User user = new User();
		int rowcount = jdbcTemplate.queryForObject(
				"select count(*) from users " + " where username = ? and password = ?", Integer.class, userName,
				encriptedPassword);
		if (rowcount == 1) {

			User u = new User();
			u.setUserName(userName);
			u.setPassword(encriptedPassword);
			user = getUserById(u);
			return user;
		}
		return user;
	}

	public User signUp(User user) {

		User newUser = new User();

		int userId = jdbcTemplate.update("INSERT INTO users(username, password) VALUES(?,?)", user.getUserName(),
				user.getPassword());
		System.out.println("Kullanıcı id: " + userId);

		if (userId > 0) {
			newUser = getUserById(user);
			return newUser;
		}
		return newUser;
	}

	public User getUserById(User u) {
		User user = new User();
		String sql = "select * from users " + " where username ='" + u.getUserName() + "' and password ='"
				+ u.getPassword() + "'";
		user = jdbcTemplate.queryForObject(sql, new UserRowMapper());
		return user;

	}

}
