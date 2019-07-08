package com.root.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.root.factory.Factory;
import com.root.pojo.User;
import com.root.util.GenerateId;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("addUser")) {
			addUser(request, response);
		} else if (method.equals("selectUser")) {
			selectUser(request, response);
		} else if (method.equals("modifyUser")) {
			modifyUser(request, response);
		} else if(method.equals("lockUser")){
			lockUser(request, response);
		}
	}

	private void lockUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String userId = request.getParameter("userId");
		String userState = request.getParameter("userState");
		boolean flag = Factory.getUserService().lockUser(userId, userState);
		if (flag) {
			request.getRequestDispatcher("/admin/selectUser.jsp").forward(request, response);
		} else {
			response.getWriter().print(
			"<script>alert('该用户状态修改失败')</script>");
		}
	}

	private void modifyUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userState = request.getParameter("userState");
		User user = new User(userId, userName, userPassword, userPhone,
				userEmail, userState);
		boolean flag = Factory.getUserService().modifyUser(userId, userName, userPassword, userPhone, userEmail);
		if (flag) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/admin/selectUser.jsp").forward(request, response);
		} else {
			response.getWriter().print(
			"<script>alert('用户信息格式有误，未能更新成功，请再次确认')</script>");
		}
	}

	private void selectUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		
		List<User> userList = Factory.getUserService().selectUser(userId, userName, userPhone, userEmail);

		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/admin/selectUser.jsp").forward(request, response);
	}

	public void addUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userState = request.getParameter("userState");
		String userId = GenerateId.generateId();
		User User = new User(userId, userName, userPassword, userPhone,
				userEmail, userState);
		boolean flag = Factory.getUserService().addUser(User);
		if (flag) {
			request.setAttribute("user", User);
			request.getRequestDispatcher("/admin/selectUser.jsp").forward(request, response);
		} else {
			response.getWriter().print(
					"<script>alert('新用户信息格式有误，未能住处成功，请再次确认')</script>");
		}
	}

}
