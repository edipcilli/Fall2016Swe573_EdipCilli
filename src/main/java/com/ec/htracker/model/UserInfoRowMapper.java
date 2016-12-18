package com.ec.htracker.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserInfoRowMapper implements RowMapper<UserInfo> {

	@Override
	public UserInfo mapRow(ResultSet rs, int arg1) throws SQLException {

		UserInfo userinf = new UserInfo();

		userinf.setId(rs.getInt("id"));
		userinf.setUserid(rs.getInt("userid"));
		userinf.setCalcday(rs.getDate("calcday"));
		userinf.setExercisecl(rs.getInt("exercisecl"));
		userinf.setFoodcl(rs.getInt("foodcl"));
		userinf.setRemainingcl(rs.getInt("remainingcl"));
		userinf.setNdbno(rs.getString("ndbno"));
		return userinf;
	}

}