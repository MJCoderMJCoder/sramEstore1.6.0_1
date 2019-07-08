package com.root.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.root.dao.IFormDao;
import com.root.pojo.Form;
import com.root.util.JdbcMysqlRoot;

public class FormDaoImpl implements IFormDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;

	@Override
	public int addForm(Form form) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "insert into Form values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, form.getFormAddress());
			ps.setString(2, form.getFormId());
			ps.setString(3, form.getFormPhone());
			ps.setString(4, form.getFormPhone());
			ps.setString(5, form.getFormUser());
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}

	@Override
	public List<Form> selectForm(String formGoods, String formUser,
			String formPostcode, String formState) {
		List<Form> FormList = new ArrayList<Form>();
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "select * from Form where formGoods like ? and formUser like ? and formPostcode like ? and formState like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+formGoods+"%");
			ps.setString(2, "%"+formUser+"%");
			ps.setString(3, "%"+formPostcode+"%");
			ps.setString(4, "%"+formState+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Form Form = new Form();
				Form.setFormId(rs.getString("formId"));
				Form.setFormGoods(rs.getString("formGoods"));
				Form.setFormUser(rs.getString("formUser"));
				Form.setFormAddress(rs.getString("formAddress"));
				Form.setFormPostcode(rs.getString("formPostcode"));
				Form.setFormPhone(rs.getString("formPhone"));
				Form.setFormState(rs.getString("formState"));
				FormList.add(Form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return FormList;
	}

	@Override
	public int modifyForm(String FormId, String FormName,
			String FormPassword, String FormPhone, String FormPost) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "update Form set FormName=?, FormPassword=?, FormPhone=?, FormPost=? where FormId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, FormName);
			ps.setString(2, FormPassword);
			ps.setString(3, FormPhone);
			ps.setString(4, FormPost);
			ps.setString(5, FormId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}

	@Override
	public int lockForm(String FormId, String FormState) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "update Form set FormState=? where FormId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, FormState);
			ps.setString(2, FormId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}

	@Override
	public int deleteForm(String formId) {
		int count = 0;
		try {
			conn = JdbcMysqlRoot.getConnectionMysqlRoot();
			sql = "delete from form where formId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, formId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcMysqlRoot.closeMysqlRoot(rs, ps, conn);
		}
		return count;
	}
}
