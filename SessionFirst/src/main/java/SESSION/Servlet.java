package SESSION;
// Service layer 
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.ha.backend.Sender;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/connectWithHtml") // this is known as url pattern 

public class Servlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException  {
		System.out.println("On the server ");
	    String user = req.getParameter("username");
		String pass = req.getParameter("password");

	    Buisness ref = new Buisness();
	    ref.isValidUser(user,pass); 	   
		
	    PrintWriter pr = res.getWriter();
	    HttpSession ses = req.getSession();
	    if(ref.isValidUser(user,pass)) {
	    	
		   
	    	System.out.println(ses.getId());  
	    	ses.setAttribute("Password",pass );
	    	res.sendRedirect("product.html");
	    	
	    	}else {
	    	res.sendRedirect("login.jsp");
	    	ses.setAttribute("msg","Wrong Credentials ");
	    	}
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}
	
}
