package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.Connection.ConnectionUtil;
import com.Model.User;

public class UserDAO {
	
	public void addUser(User user) throws Exception
	{
		Connection conn=ConnectionUtil.getConnection();
		String query="insert into user (name,email,password) values (?,?,?)";
		PreparedStatement pstate=conn.prepareStatement(query);
		pstate.setString(1, user.getName());
		pstate.setString(2, user.getEmail());
		pstate.setString(3, user.getPassword());
		int rows=pstate.executeUpdate();
		System.out.println(rows+"is updated!!!");
		
	}
	public User selectUser(User user) throws Exception
	{
		
		Connection conn=ConnectionUtil.getConnection();
		String query="select id,name from user where email=? and password=?";
		PreparedStatement pstate=conn.prepareStatement(query);
		pstate.setString(1,user.getEmail());
		pstate.setString(2, user.getPassword());
		ResultSet rs= pstate.executeQuery();
		User u=null;
		if(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			u=new User();
			u.setName(name);
			u.setId(id);
		
		}
		return u;
	}
}
