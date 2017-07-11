package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.BookDAO;
import com.DAO.UserDAO;
import com.Model.Book;
import com.Model.User;

/**
 * Servlet implementation class Signin_Controller
 */
@WebServlet("/Signin_Controller")
public class Signin_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user=new User();
		UserDAO dao=new UserDAO();
		user.setEmail(email);
		user.setPassword(password);
		try {
			User u =dao.selectUser(user);
			if(u == null){
				request.setAttribute("error", "Invalid login!!!");
				RequestDispatcher dispatcher=request.getRequestDispatcher("signin.jsp");
				dispatcher.forward(request, response);
			}
			else 
			{
				//BookDAO bd=new BookDAO();
				//List<Book> b=bd.ViewBook();
				
				//request.setAttribute("data",b );
				//RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
				//dispatcher.forward(request, response);
				response.sendRedirect("home.jsp");
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		
		
	}

}
