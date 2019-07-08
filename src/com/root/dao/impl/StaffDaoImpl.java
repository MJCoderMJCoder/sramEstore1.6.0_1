package com.root.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.root.dao.IStaffDao;
import com.root.pojo.Staff;
import com.root.util.JdbcMysqlRoot;

public class StaffDaoImpl implements IStaffDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;

	@Override
	public int addStaff(Staff staff) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "insert into staff values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, staff.getStaffId());
			ps.setString(2, staff.getStaffName());
			ps.setString(3, staff.getStaffPassword());
			ps.setString(4, staff.getStaffPhone());
			ps.setString(5, staff.getStaffPost());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}

	@Override
	public List<Staff> selectStaff(String staffId, String staffName,
			String staffPhone, String staffPost) {
		List<Staff> staffList = new ArrayList<Staff>();
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "select * from staff where staffId like ? and staffName like ? and staffPhone like ? and staffPost like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+staffId+"%");
			ps.setString(2, "%"+staffName+"%");
			ps.setString(3, "%"+staffPhone+"%");
			ps.setString(4, "%"+staffPost+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Staff staff = new Staff();
				staff.setStaffId(rs.getString("staffId"));
				staff.setStaffName(rs.getString("staffName"));
				staff.setStaffPassword(rs.getString("staffPassword"));
				staff.setStaffPhone(rs.getString("staffPhone"));
				staff.setStaffPost(rs.getString("staffPost"));
				staffList.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return staffList;
	}

	@Override
	public int modifyStaff(String staffId, String staffName,
			String staffPassword, String staffPhone, String staffPost) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "update staff set staffName=?, staffPassword=?, staffPhone=?, staffPost=? where staffId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, staffName);
			ps.setString(2, staffPassword);
			ps.setString(3, staffPhone);
			ps.setString(4, staffPost);
			ps.setString(5, staffId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}

	@Override
	public int deleteStaff(String staffId) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "delete from staff where staffId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, staffId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}
}
