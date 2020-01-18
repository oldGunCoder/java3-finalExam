package com.johnabbott.final_exam.dao;

import java.util.List;

import com.johnabbott.final_exam.model.UserEntity;

public interface UserDao {
	public int insertUser(UserEntity user); //Create
	
	public List<UserEntity> getUsers(); // Read
	
	public UserEntity getUserById(int userId); // Read
	
	public UserEntity getUserByEmail(String userEmail); //Read
	
	public boolean deleteUser(int userId); //DELETE
	
	public boolean updateUser(UserEntity user); // UPDATE
	
	
}
