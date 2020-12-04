package com.bankapp.model.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.exception.UserNotFoundException;

@Repository
public class UderDaoImpl implements UserDao{
	
	private SessionFactory factory;
	
	@Autowired
	public UderDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	public Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<User> getAllUsers() {
		return getSession().createQuery("from User").getResultList();
	}

	@Override
	public User addUser(User user) {
		User users=new User();
		getSession().save(users);
		return users;
	}

	@Override
	public User delUser(int uid) {
		User user=getUserById(uid);
		getSession().delete(user);
		return user;
	}

	@Override
	public User updateUser(User user, int uid) {
		User user1=getUserById(uid);
		user1.setAddress(user1.getAddress());
		getSession().update(user1);
		return user1;
	}

	@Override
	public boolean getUser(String username, String password) {
		Session session = factory.openSession();
		boolean userFound=false;
		String user=" from Users as o where o.userName=? and o.userPassword=?";
		Query query = session.createQuery(user);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List list=query.list();
		if((list!=null) &&((list.size())>0)) {
			userFound=true;
		}
		session.close();
		return userFound;
	}

	@Override
	public User getUserById(int Uid) {
		User user=getSession().get(User.class, Uid);
		if(user==null)
			throw new UserNotFoundException("user with id"+Uid+"was not found");
		else
		return user;
	}

}
