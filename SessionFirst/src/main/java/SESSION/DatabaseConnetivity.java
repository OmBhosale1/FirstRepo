package SESSION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnetivity implements Connectivity{

	public boolean isValid(String user, String pass) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			   e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/customers";
	    
		try {
	    
			Connection con = DriverManager.getConnection(url,"root","9ppropvl8");
	    	 String query = "select * from employee where id=? and name=?;";
	 	     PreparedStatement pstmt = con.prepareStatement(query);
	 	    pstmt.setString(1, user);
	 	    pstmt.setString(2, pass);
	 	    
	 	    ResultSet rs = pstmt.executeQuery();
	 	    
	 	    if(rs.next() == true) {
	 	    	return true;
	 	    }else{
	 	    	return false;
	 	    }
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    return false;
	}
	

}
