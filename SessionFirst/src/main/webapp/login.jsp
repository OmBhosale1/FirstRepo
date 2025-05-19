<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
this is my jsp file  
<form action="connectWithHtml" method="post">
Enter id : <input type="text" name="username"><br>

Enter Password : <input type="password" name="password"><br>


<input type="submit" value="Click" name="click">
 
</form> 
<%
String msg = (String)session.getAttribute("msg");
if(msg!=null)
	out.println(msg);
%>
	
	
</body>
</html>