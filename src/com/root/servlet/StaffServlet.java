package com.root.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.factory.Factory;
import com.root.pojo.Staff;
import com.root.util.GenerateId;

public class StaffServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("addStaff")) {
			addStaff(request, response);
		} else if (method.equals("selectStaff")) {
			selectStaff(request, response);
		} else if (method.equals("modifyStaff")) {
			modifyStaff(request, response);
		} else if(method.equals("deleteStaff")){
			deleteStaff(request, response);
		}
	}

	private void deleteStaff(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String staffId = request.getParameter("staffId");
		boolean flag = Factory.getStaffService().deleteStaff(staffId);
		if (flag) {
			response.getWriter().print("<script>alert('该员工已从系统中删除')</script>");
		} else {
			response.getWriter().print(
			"<script>alert('员工删除失败，请再次确认')</script>");
		}
	}

	private void modifyStaff(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String staffId = request.getParameter("staffId");
		String staffName = request.getParameter("staffName");
		String staffPassword = request.getParameter("staffPassword");
		String staffPhone = request.getParameter("staffPhone");
		String staffPost = request.getParameter("staffPost");
		Staff staff = new Staff(staffId, staffName, staffPassword, staffPhone,
				staffPost);
		boolean flag = Factory.getStaffService().modifyStaff(staffId, staffName, staffPassword, staffPhone, staffPost);
		if (flag) {
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/admin/selectStaff.jsp").forward(request, response);
		} else {
			response.getWriter().print(
			"<script>alert('员工信息格式有误，未能更新成功，请再次确认')</script>");
		}
	}

	private void selectStaff(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String staffId = request.getParameter("staffId");
		String staffName = request.getParameter("staffName");
		String staffPhone = request.getParameter("staffPhone");
		String staffPost = request.getParameter("staffPost");
		
		List<Staff> staffList = Factory.getStaffService().selectStaff(staffId, staffName, staffPhone, staffPost);

		request.setAttribute("staffList", staffList);
		request.getRequestDispatcher("/admin/selectStaff.jsp").forward(request, response);
	}

	public void addStaff(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String staffName = request.getParameter("staffName");
		String staffPassword = request.getParameter("staffPassword");
		String staffPhone = request.getParameter("staffPhone");
		String staffPost = request.getParameter("staffPost");
		String staffId = GenerateId.generateId();
		Staff staff = new Staff(staffId, staffName, staffPassword, staffPhone,
				staffPost);
		boolean flag = Factory.getStaffService().addStaff(staff);
		if (flag) {
			request.setAttribute("staff", staff);
			request.getRequestDispatcher("/admin/selectStaff.jsp").forward(request, response);
		} else {
			response.getWriter().print(
					"<script>alert('新员工信息格式有误，未能添加成功，请再次确认')</script>");
		}
	}

}
