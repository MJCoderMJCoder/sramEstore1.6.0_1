package com.root.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.root.dao.IUserDao;
import com.root.pojo.User;
import com.root.util.JdbcMysqlRoot;

public class UserDaoImpl implements IUserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;

	@Override
	public int addUser(User user) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "insert into user values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getUserPassword());
			ps.setString(4, user.getUserPhone());
			ps.setString(5, user.getUserEmail());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}

	@Override
	public List<User> selectUser(String userId, String userName,
			String userPhone, String userEmail) {
		List<User> userList = new ArrayList<User>();
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "select * from user where userId like ? and userName like ? and userPhone like ? and userEmail like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+userId+"%");
			ps.setString(2, "%"+userName+"%");
			ps.setString(3, "%"+userPhone+"%");
			ps.setString(4, "%"+userEmail+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserPhone(rs.getString("userPhone"));
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserState(rs.getString("userState"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return userList;
	}

	@Override
	public int modifyUser(String userId, String userName,
			String userPassword, String userPhone, String userPost) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "update user set userName=?, userPassword=?, userPhone=?, userPost=? where userId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ps.setString(3, userPhone);
			ps.setString(4, userPost);
			ps.setString(5, userId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}

	@Override
	public int lockUser(String userId, String userState) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "update user set userState=? where userId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userState);
			ps.setString(2, userId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}
}
