<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.learn.hibernate.helper.*,org.hibernate.*,com.learn.hibernate.entities.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit here</title>
<%@include file="design.jsp"%>
</head>
<body>
	<%@include file="normal_nav.jsp"%>
	<% int uid=Integer.parseInt(request.getParameter("id").trim());
 Session s=FactoryProvider.getFactory().openSession();
	User user=s.get(User.class, uid);
 %>
	<main class="primary-background" style="padding-bottom: 50px">
		<div class="container">
			<div class="col-md-6 offset-md-2">
				<div class="card">
					<div class="card-header text-center primary-background text-white">
						<span class="fa fa-3x fa-user-plus"></span> <br> Edit Here
					</div>
					<div class="card-body">
						<form action="UpdateServlet" id="reg-form" class="form"
							action="update" method="POST">
							<div class="form-group">
								<input type="hidden" class="form-control" name="id"
									value="<%= user.getId()%>">
							</div>
							<div class="form-group">
								<label for="user_name">User Name</label> <input name="name"
									type="text" class="form-control" id="user_name"
									<%= user.getName()%> required aria-describedby="emailHelp"
									placeholder="Enter user name">
							</div>
							<div class="form-group">
								<label for="exampleInputNumber">Phone</label> <input
									name="phone" type="number" class="form-control"
									id="exampleInputNumber" value="<%= user.getPhone()%>" required
									placeholder="Enter mobile number">
							</div>
							<div class="form-group">
								<label for="start">Date of birth</label> <input type="date"
									name="dob" value="<%=user.getDob() %>" required>
							</div>
							<div class="form-group">
								<label>Select City</label> <select class="form-control"
									name="city" value="<%= user.getAddress()%>">
									<option selected disabled="">--Select city--</option>
									<option>Butwal</option>
									<option>Kathmandu</option>
									<option>Nepalgunj</option>
									<option>Pokhara</option>
								</select>
							</div>
							<br>
							<button id="submit-btn" type="submit" class="btn btn-primary">Edit</button>
							<button id="reset-btn" type="reset" class="btn btn-primary">Cancel</button>
						</form>
					</div>

				</div>
			</div>
	</main>
</body>
</html>