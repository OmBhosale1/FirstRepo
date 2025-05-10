package DynamicWebAssignments;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentname = request.getParameter("studentName");
		String email = request.getParameter("email");
		 
		BuisnessLayer1 bl1 = new BuisnessLayer1();
		
		if(bl1.isValidUser(studentname, email)) {
			response.sendRedirect("Res1.html");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/Servlet2");
			rd.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
