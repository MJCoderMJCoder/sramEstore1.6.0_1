package com.root.service;

import java.util.List;

import com.root.pojo.Form;

public interface IFormService {
	public boolean addForm(Form Form);
	public List<Form> selectForm(String formGoods, String formUser, String formPostcode, String formState);;
	public boolean modifyForm(String FormId, String FormName, String FormPassword, String FormPhone, String FormPost);
	public boolean lockForm(String FormId, String FormState);
	public boolean deleteForm(String formId);
}
