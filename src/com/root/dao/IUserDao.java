package com.root.dao;

import java.util.List;

import com.root.pojo.User;

public interface IUserDao {
	public int addUser(User user);
	public List<User> selectUser(String userId, String userName, String userPhone, String userEmail);
	public int modifyUser(String userId, String userName, String userPassword, String userPhone, String userEmail);
	public int lockUser(String userId, String userState);
}
