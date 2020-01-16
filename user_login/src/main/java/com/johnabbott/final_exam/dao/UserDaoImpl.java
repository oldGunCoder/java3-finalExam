package com.johnabbott.final_exam.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.johnabbott.final_exam.model.UserEntity;


public class UserDaoImpl implements UserDao {

	JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_USER = "insert into " + "user(email, password) values(?, ?)";

	private final String SQL_UPDATE_USER = "update user set email= ? , password =? where id = ? ";

	private final String SQL_SELECT_USER = "select id, email, password" + " from user";
		
	private final String SQL_SELECT_USER_BY_ID = "select id, email, password from user where id = ?";
	
	private final String SQL_DELETE_USER = "delete from user where id = ? ";

	public UserDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insertUser(UserEntity user) {
		return jdbcTemplate.update(SQL_INSERT_USER, user.getEmail(), user.getPassword());
	}

	@Override
	public List<UserEntity> getUsers() {
		return jdbcTemplate.query(SQL_SELECT_USER, new UserMapper());
	}

	@Override
	public UserEntity getUserById(int userId) {
		return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID, 
				new Object[]{userId}, new UserMapper());
	}

	@Override
	public boolean deleteUser(int userId) {
		int deleteResult = jdbcTemplate.update(SQL_DELETE_USER, userId);
		return deleteResult > 0;
	}

	@Override
	public boolean updateUser(UserEntity user) {
		int updateResult = jdbcTemplate.update
				(SQL_UPDATE_USER, 
						user.getEmail(), 
						user.getPassword(), 
						user.getId());
		return updateResult > 0;
	}

	@Override
	public UserEntity getUserByName(String userName) {
		return null;
	}

}
