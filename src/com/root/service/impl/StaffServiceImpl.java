package com.root.service.impl;

import java.util.List;

import com.root.dao.IStaffDao;
import com.root.dao.impl.StaffDaoImpl;
import com.root.pojo.Staff;
import com.root.service.IStaffService;

public class StaffServiceImpl implements IStaffService {
	private IStaffDao staffDao;

	@Override
	public boolean addStaff(Staff staff) {
		staffDao = new StaffDaoImpl();
		int count = staffDao.addStaff(staff);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Staff> selectStaff(String staffId, String staffName, String staffPhone, String staffPost) {
		staffDao = new StaffDaoImpl();
		List<Staff> staffList = staffDao.selectStaff(staffId, staffName, staffPhone, staffPost);
		return staffList;
	}

	@Override
	public boolean modifyStaff(String staffId, String staffName,
			String staffPassword, String staffPhone, String staffPost) {
		staffDao = new StaffDaoImpl();
		int count = staffDao.modifyStaff(staffId, staffName, staffPassword, staffPhone, staffPost);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteStaff(String staffId) {
		staffDao = new StaffDaoImpl();
		int count = staffDao.deleteStaff(staffId);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}
}
