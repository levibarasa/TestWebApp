<%-- 
    Document   : home.jsp
    Created on : Jul 31, 2015, 4:28:47 PM
    Author     : Levi Barasa
--%>
<%@page import="managers.UserModel"%>
<%@page import="Service.LoginSL"%>
<%@page import="model.TblUser"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link rel="stylesheet" type="text/css" href="style.css"/>
	 <title>Home Page</title>	
</head>
<body>
<center>
	 <div id="mystyle">
		 <h1>Programming Test</h1>
		 <p><br/>
			 <b>Programming Test</b><br/>
			 <%=new Date()%></br>
			 <%
				 TblUser user = (TblUser) session.getAttribute("username");
			 %>		
			 <b>Welcome <%= user.getFirstName() + " " + user.getLastName()%></b>		
			 <br/>
			 <a href="logout.jsp">Logout</a>
		 </p>

		 <table>
			 <thead>
				 <tr>
					 <th>UserName</th>
					 <th>First Name</th>
					 <th>Last Name</th>
					 <th>Phone</th>
					 <th>Email</th>	
                                         <th>Gender</th>
                                         <th>Date Of Birth</th>
                                         <th>Status</th>
				 </tr>
			 </thead>
			 <tbody>
				 <%
					 LoginSL loginService = new LoginSL();
					 
					 for (UserModel u : loginService.getListOfUsers()) {
                                             
				 %>
				 <tr>
					 <td><%=u.getUsername()%></td>
					 <td><%=u.getFirstName()%></td>
					 <td><%=u.getLastName()%></td>
					 <td><%=u.getLastName()%></td>
                                         <td><%=u.getPhone()%></td>
					 <td><%=u.getEmail()%></td>
                                         <td><%=u.getGender()%></td>
                                         <td><%=u.getDob()%></td>
                                         <td><%=u.isStatus()%></td>
				 </tr>
				 <%}%>
			 <tbody>
		 </table>		
		 <br/>
	 </div>

</center>		
</body>
</html>
