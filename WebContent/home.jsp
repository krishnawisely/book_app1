<%@page import="com.DAO.BookDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.Model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="nav.css">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<div class="container-fluid">
	<ul class="nav navbar-nav">
		<li><a href=""><i class="glyphicon glyphicon-home"></i></a></li>
		<li><a href="">MyOrders</a></li>
		<li style="float:right">
		<form action="SearchController" method="post">
			<input type="text" name="book_name" class="search" ><button type="submit" name="hi"  class="height"><i class="glyphicon glyphicon-search"></i></button>
		</form>
		</li>
	</ul>
</div>
	
	<br>
	<% 
		String val=request.getParameter("hi");
		
		if(val == null)
		{
	%>
	<table border="1">
		<thead>
			<tr><th>BookName</th><th>AuthorName</th><th>Price</th><th>Quantity</th><th>Rating</th><th>Status</th></tr>
		</thead>
			<%
			
			BookDAO dao=new BookDAO();
			List<Book> bookList=dao.ViewBook();
			for(Book b:bookList)
			{%>
	
					<tbody>
						<tr><td><%= b.getBookname()%></td><td><%= b.getAuthorname()%></td><td><%= b.getPrice() %></td><td><%=b.getQuantity() %><td><%=b.getRating() %></td><td><%=b.getStatus() %></td>
						<td><a href="OrderBook.jsp?bookid=<%=b.getId()%>&bookname=<%= b.getBookname()%>">Order</a></td>
						</tr>
					</tbody>
    			<%}%>
    			</table>
	
	<% }%>
	<%if(val != null){%>
	
			<table border="1">
		<thead>
			<tr><th>BookName</th><th>AuthorName</th><th>Price</th><th>Quantity</th><th>Rating</th><th>Status</th></tr>
		</thead>
		
					<tbody>
			<%
			 List<Book> booklist =(List<Book>)request.getAttribute("bookkey");
			 
			
			
			for(Book b:booklist)
			{%>
	
						<tr><td><%= b.getBookname()%></td><td><%= b.getAuthorname()%></td><td><%= b.getPrice() %></td><td><%=b.getQuantity() %><td><%=b.getRating() %></td><td><%=b.getStatus() %></td><td><a href="OrderBook.jsp"><input type="Button" name="ok1" value="submit"></a></td></tr>
					
			<% }%>
			
			</tbody>
		</table>
		
	<% }%>
	
	
</body>
</html>