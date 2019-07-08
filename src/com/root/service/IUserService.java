package com.root.service;

import java.util.List;

import com.root.pojo.User;

public interface IUserService {
	public boolean addUser(User user);
	public List<User> selectUser(String userId, String userName, String userPhone,
			String UserPost);
	public boolean modifyUser(String userId, String userName, String userPassword, String userPhone, String userPost);
	public boolean lockUser(String userId, String userState);
}
