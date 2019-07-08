package com.root.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.root.factory.Factory;
import com.root.pojo.Form;
import com.root.util.GenerateId;

public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("addForm")) {
			addForm(request, response);
		} else if (method.equals("selectForm")) {
			selectForm(request, response);
		} else if (method.equals("modifyForm")) {
			modifyForm(request, response);
		} else if(method.equals("lockForm")){
			lockForm(request, response);
		}
	}

	private void lockForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String FormId = request.getParameter("FormId");
		String FormState = request.getParameter("FormState");
		if(FormState.equals("删除")){
			deleteForm(request, response);
		}else{
			boolean flag = Factory.getFormService().lockForm(FormId, FormState);
			if (flag) {
				response.getWriter().print("<script>alert('该订单状态已修改成功')</script>");
			} else {
				response.getWriter().print(
				"<script>alert('该订单状态修改失败')</script>");
			}
		}
	}
	
	private void deleteForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String formId = request.getParameter("FormId");
		boolean flag = Factory.getFormService().deleteForm(formId);
		if (flag) {
			response.getWriter().print("<script>alert('该订单已从系统中删除')</script>");
		} else {
			response.getWriter().print(
			"<script>alert('订单删除失败，请再次确认')</script>");
		}
	}
	
	private void modifyForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String FormId = request.getParameter("FormId");
		String FormName = request.getParameter("FormName");
		String FormPassword = request.getParameter("FormPassword");
		String FormPhone = request.getParameter("FormPhone");
		String FormEmail = request.getParameter("FormEmail");
		String FormState = request.getParameter("FormState");
		Form Form = new Form();
		boolean flag = Factory.getFormService().modifyForm(FormId, FormName, FormPassword, FormPhone, FormEmail);
		if (flag) {
			request.setAttribute("Form", Form);
			request.getRequestDispatcher("/admin/selectForm.jsp").forward(request, response);
		} else {
			response.getWriter().print(
			"<script>alert('用户信息格式有误，未能更新成功，请再次确认')</script>");
		}
	}

	private void selectForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String formGoods = request.getParameter("formGoods");
		String formUser = request.getParameter("formUser");
		String formPostcode = request.getParameter("formPostcode");
		String formState = request.getParameter("formState");
		
		List<Form> formList = Factory.getFormService().selectForm(formGoods, formUser, formPostcode, formState);

		request.setAttribute("formList", formList);
		request.getRequestDispatcher("/admin/selectForm.jsp").forward(request, response);
	}

	public void addForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String FormName = request.getParameter("FormName");
		String FormPassword = request.getParameter("FormPassword");
		String FormPhone = request.getParameter("FormPhone");
		String FormEmail = request.getParameter("FormEmail");
		String FormState = request.getParameter("FormState");
		String FormId = GenerateId.generateId();
		Form Form = new Form();
		boolean flag = Factory.getFormService().addForm(Form);
		if (flag) {
			request.setAttribute("Form", Form);
			request.getRequestDispatcher("/admin/selectForm.jsp").forward(request, response);
		} else {
			response.getWriter().print(
					"<script>alert('新用户信息格式有误，未能住处成功，请再次确认')</script>");
		}
	}

}
