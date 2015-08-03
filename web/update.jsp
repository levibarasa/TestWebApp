<%-- 
    Document   : update.jsp
    Created on : Aug 1, 2015, 11:33:19 PM
    Author     : Levi Barasa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <center>
	 <div id="mystyle" class="myform">
		 <form id="form" name="form" method="post" action="RegisterServlet">
			 <h1>Update Settings</h1>
			 <p>Please enter the following information</p>

			 <label>UserName
				 <span class="small">Enter your first name</span>
			 </label>
			 <input type="text" name="firstName" id="firstName" />

			 <label>Password
				 <span class="small">Enter your middle name</span>
			 </label>
			 <input type="text" name="middleName" id="middleName" />

			 <label>Password
				 <span class="small">Password min. 6 chars</span>
			 </label>
			 <input type="text" name="password" id="password" />

			 <button type="submit">Update</button>
			 <div class="spacer"></div>

		 </form>
	 </div>
</center>
    </body>
</html>
