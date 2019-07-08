package com.root.service.impl;

import java.util.List;

import com.root.dao.IFormDao;
import com.root.dao.impl.FormDaoImpl;
import com.root.dao.impl.StaffDaoImpl;
import com.root.pojo.Form;
import com.root.service.IFormService;

public class FormServiceImpl implements IFormService {
	private IFormDao FormDao;

	@Override
	public boolean addForm(Form Form) {
		FormDao = new FormDaoImpl();
		int count = FormDao.addForm(Form);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Form> selectForm(String formGoods, String formUser,
			String formPostcode, String formState) {
		FormDao = new FormDaoImpl();
		List<Form> formList = FormDao.selectForm(formGoods, formUser, formPostcode, formState);
		return formList;
	}

	@Override
	public boolean modifyForm(String FormId, String FormName,
			String FormPassword, String FormPhone, String FormPost) {
		FormDao = new FormDaoImpl();
		int count = FormDao.modifyForm(FormId, FormName, FormPassword, FormPhone, FormPost);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean lockForm(String FormId, String FormState) {
		FormDao = new FormDaoImpl();
		int count = FormDao.lockForm(FormId, FormState);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteForm(String formId) {
		FormDao = new FormDaoImpl();
		int count = FormDao.deleteForm(formId);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}
}
