package Java_CaseStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateMyConnection {
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		String url = "jdbc:mysql://localhost:3306/customers";
		try {
			Connection con = null;
			con = DriverManager.getConnection(url, "root", "9ppropvl8");
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
}