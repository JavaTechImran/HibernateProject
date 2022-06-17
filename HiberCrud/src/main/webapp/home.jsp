<%@page import="com.learn.HiberCrud.dao.UserDao"%>
<%@page import="com.learn.HiberCrud.entities.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<%@include file="design.jsp" %>
</head>
<body>
 <%@include file="normal_nav.jsp" %>
 
 <h3 class="text-center">List of User</h3>
        <table class="table table-striped table-dark text-center" method="post">
            <thead>
                <tr>
                    <th colspan="col">Id</th>
                    <th colspan="col">Name</th>
                    <th colspan="col">Email</th>
                    <th colspan="col">phone</th>
                    <th colspan="col">DOB</th>
                    <th colspan="col">Address</th>
                    <th colspan="col">Action</th>
                </tr>
            </thead>
            <tbody>
            <%
            List<User> list=UserDao.getHomeUsers();
            for(User user:list){
            	%>
            	<tr>
            	<th colspan="row"><%=user.getId() %></th>
            	<td><%= user.getName() %></td>
	<td><%= user.getEmail() %></td>
	<td><%= user.getPhone() %></td>
	<td><%= user.getDob() %></td>
	<td><%= user.getAddress() %></td>
	<td>
                       
                        <a class="btn btn-success" href="edit.jsp?id=<%= user.getId()%>">Update</a>
                       <a class="btn btn-danger" href="DeleteServlet?id=<%= user.getId()%>">Delete</a>
                    </td>
            	</tr>
            	
            	
            	<%
            }
            %>
            </tbody>
            </table>
 
</body>
</html>