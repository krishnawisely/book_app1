package com.test;

import com.DAO.BookDAO;
import com.Model.Book;

public class BookDAOTest {

	public static void main(String[] args) throws Exception {
		BookDAO dao=new BookDAO();
		Book book=new Book();
		book.setBookname("Network");
		book.setPrice(100.00);
		book.setAuthorname("krishna");
		book.setQuantity(4);
		book.setRating(4);
		book.setStatus("order");
		dao.AddBook(book);
		
	}

}
