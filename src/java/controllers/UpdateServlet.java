/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Service.RegisterSL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TblUser;

/**
 *
 * @author Levi Barasa
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 String username = request.getParameter("username");
	 String password = request.getParameter("password");
	 TblUser user = new TblUser( username,  password);
			
	 try {	
		 RegisterSL registerService = new RegisterSL();
		 boolean result = registerService.register(user);		
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Registration Successful</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 if(result){
			 out.println("<h1>Registration Successful</h1>");
			 out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
		 }else{
			 out.println("<h1>Registration Unsuccessful</h1>");
			 out.println("To try again<a href=register.jsp>Click here</a>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 } finally {		
		 out.close();
	 }
}
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 processRequest(request, response);
}
@Override
public String getServletInfo() {
	 return "Short description";
}   
}
