<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
String bookName = request.getParameter("bookname");

String bookId = request.getParameter("bookid");
%>

Order Book:
	<form action="OrderController" method="get">
	 <input type="hidden" name="book_id" value="<%=bookId%>"  required readonly>
	Book Name <input type="text" name="book_name" value="<%=bookName%>"  required readonly>
	
	Quantity :<input type="number" name="quantity" min="1" max="10" required >
	
	<button type="submit" > Order </button>
	
	</form>
"WebContent/home.jsp"
</body>
</html>