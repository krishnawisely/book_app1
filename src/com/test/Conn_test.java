package com.test;

import java.sql.Connection;
import com.Connection.ConnectionUtil;

public class Conn_test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Connection conn=ConnectionUtil.getConnection();
		System.out.println(conn+"Connection is successful");
	}

}
