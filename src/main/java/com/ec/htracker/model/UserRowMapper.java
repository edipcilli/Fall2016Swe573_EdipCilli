package com.ec.htracker.model;

import java.sql.Date;
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
		user.setCurrentweight(rs.getDouble("currentweight"));
        user.setHeight(rs.getInt("height"));
        user.setDateofbirth(rs.getDate("dateofbirth"));
        user.setGoalweight(rs.getDouble("goalweight"));
        user.setGoaldate(rs.getDate("goaldate"));
        user.setNotes(rs.getString("notes"));
        user.setCurrentBMI(rs.getDouble("currentBMI"));
        user.setGoalBMI(rs.getDouble("goalBMI"));
        user.setDailycalory(rs.getInt("dailycalory"));

		return user;
	}

}