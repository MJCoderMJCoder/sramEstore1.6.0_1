package com.root.pojo;

public class Staff {
	private String staffId;
	private String staffName;
	private String staffPassword;
	private String staffPhone;
	private String staffPost; //员工职务岗位
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	public String getStaffPost() {
		return staffPost;
	}
	public void setStaffPost(String staffPost) {
		this.staffPost = staffPost;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(String staffId, String staffName, String staffPassword,
			String staffPhone, String staffPost) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffPassword = staffPassword;
		this.staffPhone = staffPhone;
		this.staffPost = staffPost;
	}
	
}
