package com.johnabbott.final_exam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.final_exam.model.UserEntity;

@Repository
public class HibernateUserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
//	@Override
//	public int insertUser(UserEntity user) {
//		sessionFactory.getCurrentSession().save(user);
//		sessionFactory.getCurrentSession().save(user.getAddress());
//		
//		return 1;
//	}

	@Override
	public List<UserEntity> getUsers() {
		//User is not the table name => it is the class name(@Entity)
		return getSession().createQuery("from UserEntity", UserEntity.class).list();
	}

	@Override
	public UserEntity getUserById(int userId) {
		return (UserEntity) getSession().get(UserEntity.class, userId);
	}
	
	public UserEntity getUserByEmail(String userEmail) {
		String hql = "from UserEntity where email= :user_email";
		Query query = getSession().createQuery(hql);
		query.setParameter("user_email",userEmail);
		if (query.list().size() > 0) {
			return (UserEntity)query.list().get(0);
		}
		else {
			return null;
		}
			
		
	}

	@Override
	public boolean deleteUser(int userId) {
		UserEntity fetchedUser = getUserById(userId);
		getSession().delete(fetchedUser);
		return true;
	}

	@Override
	public boolean updateUser(UserEntity user) {
		getSession().update(user);
		return true;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int insertUser(UserEntity user) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public UserEntity getUserByEmail(String userEmail) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
