package com.johnabbott.final_exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.final_exam.dao.UserDao;
import com.johnabbott.final_exam.model.UserEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	List<UserEntity> listUsers;
	
	public UserServiceImpl() {
		listUsers = new ArrayList<UserEntity>();
		
		listUsers.add(new UserEntity(1, "toto1@gmail.com", "popo1"));
		listUsers.add(new UserEntity(2, "toto2@gmail.com", "popo2"));
		listUsers.add(new UserEntity(3, "toto3@gmail.com", "popo3"));
		listUsers.add(new UserEntity(4, "toto4@gmail.com", "popo4"));
	}
	
	@Override
	public List<UserEntity> getUsers(){
		return userDao.getUsers();
	}

	@Override
	public boolean addUser(UserEntity user) {
		return userDao.insertUser(user) > 0 ;
	}

	@Override
	public UserEntity getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public boolean deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public boolean updateUser(UserEntity user) {
		return userDao.updateUser(user);
	}
}
