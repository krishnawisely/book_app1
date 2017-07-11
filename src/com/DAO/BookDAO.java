package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.ConnectionUtil;
import com.Model.Book;
public class BookDAO
{

	public void AddBook(Book book)throws Exception
	{
		
		Connection conn= ConnectionUtil.getConnection();
		
		String query="insert into book(name,price,authorname,rating,status,quantity)values(?,?,?,?,?,?)";
		PreparedStatement pmt=conn.prepareStatement(query);
		pmt.setString(1, book.getBookname());
		pmt.setDouble(2, book.getPrice());
		pmt.setString(3, book.getAuthorname());
		pmt.setInt(4, book.getRating());
		pmt.setString(5,book.getStatus());
		pmt.setInt(6, book.getQuantity());
		
		int cal=pmt.executeUpdate();
		System.out.println(cal+"rows is updated");
		
		
		
	}
	
	public  List<Book> ViewBook()throws Exception
	{
		Connection conn=ConnectionUtil.getConnection();
		
		List<Book> booklist=new ArrayList<Book>();
		
		String query="select id,name,price,authorname,rating,status,quantity from book";
		PreparedStatement pmt=conn.prepareStatement(query);
		
		ResultSet rs=  pmt.executeQuery(query);
		
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name=rs.getString("name");
			double price=rs.getDouble("price");
			String authorname=rs.getString("authorname");
			int rating=rs.getInt("rating");
			String status=rs.getString("status");
			int quantity=rs.getInt("quantity");
			
			Book b=new Book();
			b.setId(id);
			b.setBookname(name);
			b.setPrice(price);
			b.setAuthorname(authorname);
			b.setRating(rating);
			b.setStatus(status);
			b.setQuantity(quantity);
		
			
			booklist.add(b);
		}
		
		return booklist;
		
		
	}
	
	public List<Book> searchBook(Book book) throws Exception
	{
		Connection conn=ConnectionUtil.getConnection();
		List<Book> booklist=new ArrayList<Book>();
		String query="select * from book where name=?";
		PreparedStatement pstate=conn.prepareStatement(query);
		pstate.setString(1, book.getBookname());
		ResultSet rs=pstate.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name=rs.getString("name");
			double price=rs.getDouble("price");
			String authorname=rs.getString("authorname");
			int rating=rs.getInt("rating");
			String status=rs.getString("status");
			int quantity=rs.getInt("quantity");
			book.setId(id);
			book.setBookname(name);
			book.setPrice(price);
			book.setAuthorname(authorname);
			book.setRating(rating);
			book.setStatus(status);
			book.setQuantity(quantity);
			booklist.add(book);
		}
		return booklist;
		
		
	}
	
	}
