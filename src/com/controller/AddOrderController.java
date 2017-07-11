package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.User;


/**
 * Servlet implementation class User_Controller
 */
@WebServlet("/AddOrderController")
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid = request.getParameter("book_id");
		String qty = request.getParameter("quantity");

		// convertion
		int bookId = Integer.parseInt(bid);
		int quantity = Integer.parseInt(qty);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		int userId = user.getId();
		
		//Model
		
		try {
			// dao.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("signin.jsp");

	}

}
