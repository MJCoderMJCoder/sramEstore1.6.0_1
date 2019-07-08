package com.root.dao;

import java.util.List;

import com.root.pojo.Form;

public interface IFormDao {
	public int addForm(Form form);
	public List<Form> selectForm(String formGoods, String formUser, String formPostcode, String formState);
	public int modifyForm(String formId, String formName, String formPassword, String formPhone, String formEmail);
	public int lockForm(String FormId, String FormState);
	public int deleteForm(String formId);
}
