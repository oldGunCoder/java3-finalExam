package com.johnabbott.final_exam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.johnabbott.final_exam.model.UserEntity;

public class UserMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UserEntity(rs.getInt("id"), rs.getString("email"),
				rs.getString("password"));
	}

}
