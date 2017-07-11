package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.BookDAO;

import com.Model.Book;




/**
 * Servlet implementation class AddbookController
 */
@WebServlet("/AddbookController")
public class AddbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddbookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("book_name");
		String price=request.getParameter("book_price");
		Double book_price=Double.parseDouble(price);
		String author_name=request.getParameter("author_name");
		String quantity=request.getParameter("quantity");
		int book_quantity=Integer.parseInt(quantity);
		String rating=request.getParameter("rating");
		int book_rating=Integer.parseInt(rating);
		String status=request.getParameter("status");
		Book book=new Book();
		BookDAO dao=new BookDAO();
		book.setBookname(name);
		book.setPrice(book_price);
		book.setAuthorname(author_name);
		book.setQuantity(book_quantity);
		book.setRating(book_rating);
		book.setStatus(status);
		try {
			dao.AddBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
