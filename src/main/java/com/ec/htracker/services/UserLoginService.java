package com.ec.htracker.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.ec.htracker.model.User;
import com.ec.htracker.model.UserInfo;
import com.ec.htracker.model.UserInfoRowMapper;
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
//hesaplamaları da yapıp öyle oluşturalım kaydı. BMI değerleri ve günlük harcanması gereken kalori değerleri hesaplanacak.
		//double currentbmi = (user.getCurrentweight() / (user.getHeight() * user.getHeight())) * 10000;
		//user.setCurrentBMI(currentbmi);
		//double targetbmi = (user.getGoalweight() / (user.getHeight() * user.getHeight())) * 10000;
		//user.setGoalBMI(targetbmi);
		
		Date targetdate = user.getGoaldate();
		@SuppressWarnings("deprecation")
		int totaldays = targetdate.getYear() * 365 + targetdate.getMonth() * 30 + targetdate.getDay();
		
		@SuppressWarnings("deprecation")
		Date currentday = new Date();
		int currentdaystotal = currentday.getYear() * 365 + currentday.getMonth() * 30 + currentday.getDay() ;

//günlük alınması gereken kalori miktarı. Bir kilo vermek 7400 kalori.  ortalama günlük kalori 2500.
		int dailycaloriestotake = 2500 - (int)(((user.getCurrentweight()- user.getGoalweight()) * 7400) / (totaldays - currentdaystotal));
		
		
		System.out.println("signup yapacik");
		int userId = jdbcTemplate.update("INSERT INTO users(username, password, currentweight,height,dateofbirth,goalweight,goaldate,notes,currentBMI,goalBMI,dailycalory,gender) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", user.getUserName(),
				user.getPassword(),user.getCurrentweight(), user.getHeight(),user.getDateofbirth(),user.getGoalweight(),user.getGoaldate(),user.getNotes(),user.getCurrentBMI(),user.getGoalBMI(),dailycaloriestotake,user.getGender());
		System.out.println("Kullanıcı id: " + userId);		
						
		
		if (userId > 0) {
			newUser = getUserById(user);
			
			System.out.println("userinfoyu da initialize edelim.");
			System.out.println(newUser.getId());
			int userinforesult = jdbcTemplate.update("INSERT INTO userinfo(userid, foodcl, exercisecl,calcday,remainingcl) VALUES(?,?,?,?,?)", newUser.getId(),0,0,currentday,newUser.getDailycalory());
			
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
	
	public UserInfo getUserInfo(User u) {
		UserInfo userinf = new UserInfo();
		Date currentday = new Date();
				
		System.out.println("userınf getiricez.");
		System.out.println(currentday);
		System.out.println(u.getId());
		
//şimdilik bir gün için oku ama sonra ekleme yap sadece ilgili gün için okusun.
		
		
		String sql = "select * from userinfo " + " where userid ='" + u.getId() + "'";
		userinf = jdbcTemplate.queryForObject(sql, new UserInfoRowMapper());
		
		System.out.println(userinf.getUserid());
		System.out.println(userinf.getExercisecl());
		System.out.println(userinf.getFoodcl());
		System.out.println(userinf.getRemainingcl());
		System.out.println(userinf.getCalcday());
		return userinf;

	}
	
	public UserInfo addFoodToDB(int userId, String ndbno, int energy){
		Date dt = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String currentTime = sdf.format(dt);
		
		UserInfo userinf = new UserInfo();
		String sql = "select * from userinfo where userid ='" + userId + "'";
		userinf = jdbcTemplate.queryForObject(sql, new UserInfoRowMapper());
		String updatedNdbno;
		int updatedEnergy;
		if(!userinf.getNdbno().isEmpty()){
			updatedNdbno = userinf.getNdbno() + "," + ndbno;
		}
		else{
			updatedNdbno = ndbno;
		}
		updatedEnergy = userinf.getFoodcl() + energy;
		int success = jdbcTemplate.update("UPDATE userinfo SET ndbno = '"+ updatedNdbno + "', foodcl = '" + updatedEnergy +"'  WHERE userid = '"+ userId + "';");
		
		UserInfo userinf2 = new UserInfo();
		String sql2 = "select * from userinfo where userid ='" + userId + "'";
		userinf2 = jdbcTemplate.queryForObject(sql2, new UserInfoRowMapper());
		return userinf2;
	}
	
	public UserInfo getHistory(int userId, String date){
		String sql = "select * from userinfo where userid ='" + userId + "' AND calcday = '" + date +"';";
		UserInfo userinf = new UserInfo();
		userinf = jdbcTemplate.queryForObject(sql, new UserInfoRowMapper());
		
		return userinf;
		
	}
	
	

}
