package com.root.service.impl;

import java.util.List;

import com.root.dao.IUserDao;
import com.root.dao.impl.UserDaoImpl;
import com.root.pojo.User;
import com.root.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao UserDao;

	@Override
	public boolean addUser(User user) {
		UserDao = new UserDaoImpl();
		int count = UserDao.addUser(user);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<User> selectUser(String userId, String userName, String userPhone, String userEmail) {
		UserDao = new UserDaoImpl();
		List<User> userList = UserDao.selectUser(userId, userName, userPhone, userEmail);
		return userList;
	}

	@Override
	public boolean modifyUser(String userId, String userName,
			String userPassword, String userPhone, String userPost) {
		UserDao = new UserDaoImpl();
		int count = UserDao.modifyUser(userId, userName, userPassword, userPhone, userPost);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean lockUser(String userId, String userState) {
		UserDao = new UserDaoImpl();
		int count = UserDao.lockUser(userId, userState);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}
}
