package com.johnabbott.final_exam.service;

import java.util.List;

import com.johnabbott.final_exam.model.UserEntity;

public interface UserService {
	public boolean addUser(UserEntity user);
	
	public List<UserEntity> getUsers(); // Read
	
	public UserEntity getUserById(int userId); // Read
	
	public boolean deleteUser(int userId); //DELETE
	
	public boolean updateUser(UserEntity user); // UPDATE
}
