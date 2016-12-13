package com.ec.htracker.services;

import java.util.Iterator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ec.htracker.model.User;
import com.ec.htracker.model.UserRowMapper;
import java.util.Date;
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
//hesaplamaları da yapıp öyle oluşturalım kaydı. BMI değerleri ve günlük harcanması gereken kalori değerleri hesaplanacak.
		double currentbmi = (user.getCurrentweight() / (user.getHeight() * user.getHeight())) * 10000;
		user.setCurrentBMI(currentbmi);
		double targetbmi = (user.getGoalweight() / (user.getHeight() * user.getHeight())) * 10000;
		user.setGoalBMI(targetbmi);
		
		Date targetdate = user.getGoaldate();
		@SuppressWarnings("deprecation")
		int totaldays = targetdate.getYear() * 365 + targetdate.getMonth() * 30 + targetdate.getDay();
		
		@SuppressWarnings("deprecation")
		Date currentday = new Date();
		int currentdaystotal = currentday.getYear() * 365 + currentday.getMonth() * 30 + currentday.getDay() ;

//günlük alınması gereken kalori miktarı. Bir kilo vermek 7400 kalori.  ortalama günlük kalori 2500.
		int dailycaloriestotake = 2500 - (int)(((user.getCurrentweight()- user.getGoalweight()) * 7400) / (totaldays - currentdaystotal));
		
		
		System.out.println("signup yapacik");
		int userId = jdbcTemplate.update("INSERT INTO users(username, password, currentweight,height,dateofbirth,goalweight,goaldate,notes,currentBMI,goalBMI,dailycalory) VALUES(?,?,?,?,?,?,?,?,?,?,?)", user.getUserName(),
				user.getPassword(),user.getCurrentweight(), user.getHeight(),user.getDateofbirth(),user.getGoalweight(),user.getGoaldate(),user.getNotes(),user.getCurrentBMI(),user.getGoalBMI(),dailycaloriestotake);
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
