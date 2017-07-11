package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.ConnectionUtil;
import com.Model.Book;
import com.Model.Order;

public class OrderDAO
{

	
	public void OrderBook(Order book)throws Exception
	{
		
		Connection conn= ConnectionUtil.getConnection();
		
		String query="insert into book(user_id,book_name,quantity)values(?,?,?)";
		PreparedStatement pmt=conn.prepareStatement(query);
		pmt.setInt(1, book.getUser_id());
		pmt.setString(2, book.getbookname());
		pmt.setInt(3, book.getQuantity());
		
		
		int cal=pmt.executeUpdate();
		System.out.println(cal+"rows is updated");
		
	}
	public List<Order> selectBook(Order book) throws Exception
	{
		Connection conn=ConnectionUtil.getConnection();
		List<Order> booklist=new ArrayList<Order>();
		String query="select * from book where name=?";
		PreparedStatement pstate=conn.prepareStatement(query);
		pstate.setString(1, book.getbookname());
		ResultSet rs=pstate.executeQuery();
		while(rs.next())
		{
			String name=rs.getString("book_name");
			int user_id=(int) rs.getDouble("user_id");
			int quantity=rs.getInt("quantity");
			Order order=new Order();
			book.setbookname(name);
			book.setQuantity(quantity);
			book.setUser_id(user_id);
			booklist.add(book);
		}
		return booklist;
		
		
	}
	
}
