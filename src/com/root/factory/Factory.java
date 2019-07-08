package com.root.factory;

import com.root.service.IFormService;
import com.root.service.IStaffService;
import com.root.service.IUserService;
import com.root.service.impl.FormServiceImpl;
import com.root.service.impl.StaffServiceImpl;
import com.root.service.impl.UserServiceImpl;

public class Factory {
	
	public static IStaffService getStaffService(){
		return new StaffServiceImpl();
	}
	public static IUserService getUserService(){
		return new UserServiceImpl();
	}
	public static IFormService getFormService(){
		return new FormServiceImpl();
	}
}
