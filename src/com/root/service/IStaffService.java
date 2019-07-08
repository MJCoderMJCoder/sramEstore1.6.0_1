package com.root.service;

import java.util.List;

import com.root.pojo.Staff;

public interface IStaffService {
	public boolean addStaff(Staff staff);
	public List<Staff> selectStaff(String staffId, String staffName, String staffPhone,
			String staffPost);
	public boolean modifyStaff(String staffId, String staffName, String staffPassword, String staffPhone, String staffPost);
	public boolean deleteStaff(String staffId);
}
