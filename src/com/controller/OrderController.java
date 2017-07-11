package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.OrderDAO;
import com.Model.Order;


@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
                         String user_id=request.getParameter("book_id");
                         String book_name=request.getParameter("book_name");
                         String qty=request.getParameter("quantity");
                         
                         int userid=Integer.parseInt(user_id);
                         int quantity=Integer.parseInt(qty);
                         Order order=new Order();
                         order.setUser_id(userid);
                         order.setbookname(book_name);
                         order.setQuantity(quantity);
                         OrderDAO dao= new OrderDAO();
                         try {
							List<Order> list_orders=dao.selectBook(order);
							request.setAttribute("list_order", list_orders);
							RequestDispatcher dispatcher=request.getRequestDispatcher("ShowOrders.jsp");
							dispatcher.forward(request, response);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Values not go dao!!!");
						}
	
	}

	

}
