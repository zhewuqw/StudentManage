<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Passing Model to MVC example</title>
</head>
<body>
	<h1>You are logged in as ${it.user}!</h1>
	<p>
		Students available in the store :<br />
		<%
			HashMap<String, Object> it = (HashMap<String, Object>) pageContext
					.findAttribute("it");
			for (Student stu : (ArrayList<Student>) it.get("stus")) {
				out.println("<br><br><b>ID:&nbsp;" + stu.getId()
						+ "</b><b>---------->Name:&nbsp;" + stu.getName()
						+ "</b><b>---------->Email:&nbsp;" + stu.getEmail()
						+ "</b><b>---------->Phone:&nbsp;" + stu.getPhone()
						+ "</b><b>---------->Sex:&nbsp;" + stu.getSex()
						+ "</b><b>---------->Age:&nbsp;" + stu.getAge()
						+ "</b><b>---------->Address:&nbsp;"
						+ stu.getAddress());
			}
		%>
	</p>
</body>
</html>