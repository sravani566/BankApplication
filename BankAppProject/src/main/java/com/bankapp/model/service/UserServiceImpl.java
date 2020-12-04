package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.User;
import com.bankapp.model.dao.UserDao;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public User delUser(int uid) {
		return userDao.delUser(uid);
	}

	@Override
	public User updateUser(User user, int uid) {
		return userDao.updateUser(user, uid);
	}

	@Override
	public boolean getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

	@Override
	public User getUserById(int Uid) {
		return userDao.getUserById(Uid);
	}

}
