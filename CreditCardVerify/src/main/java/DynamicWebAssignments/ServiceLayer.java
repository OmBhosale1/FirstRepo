package DynamicWebAssignments;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Authenticate")
public class ServiceLayer extends HttpServlet {
	
     
 
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	System.out.println("On the server");
    	String cardNo = req.getParameter("cardNo");
    	String from = req.getParameter("from");
    	String expiry = req.getParameter("expiry");
    	String cvv = req.getParameter("cvv");
    	
    	
    	
    	BuisnessLayer bs = new BuisnessLayer();
		PrintWriter pr = res.getWriter();
		
		if(bs.isValidUser(cardNo,from,expiry, cvv)) {
			pr.print("Valid");
		}else {
			pr.print("Invalid");
		}
		 RequestDispatcher rd = req.getRequestDispatcher("Servlet2");
		 rd.forward(req, res);
	}
    
   

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		doGet(req, res);
	}

}
