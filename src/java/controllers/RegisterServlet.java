/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Levi Barasa
 */
import Service.RegisterSL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.SendMail;
import model.TblUser;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 String username = request.getParameter("username");
	 String password = request.getParameter("password");
	 String firstName = request.getParameter("firstName");
	 String lastName = request.getParameter("lastName");
	 String gender = request.getParameter("gender");
	 String dob = request.getParameter("dob");
         String email = request.getParameter("email");
         String phone = request.getParameter("phone");
         String activationCode = request.getParameter("activationCode");
         boolean status = Boolean.getBoolean(request.getParameter("status"));
	 TblUser user = new TblUser( username,  password, firstName, lastName, gender,  dob,email, phone,activationCode, status);
			
	 try {	
		 RegisterSL registerService = new RegisterSL();
		 boolean result = registerService.register(user);
                 SendMail.send("Test Web App", "lvbarasa@gmail.com", "yellowagency@2015", email, null, "Complete Registration Process", "text/html; charset=utf-8");
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Registration Successful</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 if(result){
			 out.println("<h1>Registration Successful</h1>");
			 out.println("Before you login with new UserName and Password, <a href=update.jsp>Click here To update your password</a>");
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