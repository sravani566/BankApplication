package com.bankapp.model.dao;
import java.util.*;
public interface UserDao {
	
	List<User> getAllUsers();
	public User addUser(User user);
	public User delUser(int uid);
	public User updateUser(User user,int uid);
	public boolean getUser(String username,String password);
	public User getUserById(int Uid);
	

}
