package com.ec.htracker.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {

		User user = new User();

		user.setId(rs.getInt("id"));
		user.setPassword(rs.getString("password"));
		user.setUserName(rs.getString("username"));
		user.setGoalcl(rs.getInt("goalcl"));
		user.setFoodcl(rs.getInt("foodcl"));
		user.setExercisecl(rs.getInt("exercisecl"));
		

		return user;
	}

}