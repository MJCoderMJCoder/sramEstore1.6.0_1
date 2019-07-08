package com.root.dao;

import java.util.List;

import com.root.pojo.Staff;

public interface IStaffDao {
	public int addStaff(Staff staff);
	public List<Staff> selectStaff(String staffId, String staffName, String staffPhone, String staffPost);
	public int modifyStaff(String staffId, String staffName, String staffPassword, String staffPhone, String staffPost);
	public int deleteStaff(String staffId);
}
