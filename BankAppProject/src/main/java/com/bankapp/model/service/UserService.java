package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.User;

public interface UserService {
	List<User> getAllUsers();
	public User addUser(User user);
	public User delUser(int uid);
	public User updateUser(User user,int uid);
	public boolean getUser(String username,String password);
	public User getUserById(int Uid);


}
