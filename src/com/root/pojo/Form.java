package com.root.pojo;

public class Form {
	private String formId;
	private String formGoods; //订单里值包含的物品
	private String formUser; //下订单的用户（买家）
	private String formAddress; //发货地址
	private String formPostcode; //邮编
	private String formPhone; //收件人联系方式
	private String formState; //订单状态
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getFormGoods() {
		return formGoods;
	}
	public void setFormGoods(String formGoods) {
		this.formGoods = formGoods;
	}
	public String getFormUser() {
		return formUser;
	}
	public void setFormUser(String formUser) {
		this.formUser = formUser;
	}
	public String getFormAddress() {
		return formAddress;
	}
	public void setFormAddress(String formAddress) {
		this.formAddress = formAddress;
	}
	public String getFormPostcode() {
		return formPostcode;
	}
	public void setFormPostcode(String formPostcode) {
		this.formPostcode = formPostcode;
	}
	public String getFormPhone() {
		return formPhone;
	}
	public void setFormPhone(String formPhone) {
		this.formPhone = formPhone;
	}
	public String getFormState() {
		return formState;
	}
	public void setFormState(String formState) {
		this.formState = formState;
	}
	public Form(String formId, String formGoods, String formUser,
			String formAddress, String formPostcode, String formPhone,
			String formState) {
		super();
		this.formId = formId;
		this.formGoods = formGoods;
		this.formUser = formUser;
		this.formAddress = formAddress;
		this.formPostcode = formPostcode;
		this.formPhone = formPhone;
		this.formState = formState;
	}
	public Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
