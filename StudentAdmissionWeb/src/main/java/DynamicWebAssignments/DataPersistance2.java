package DynamicWebAssignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataPersistance2 implements DataAccessLayer {

	@Override
	public Boolean isValid(String studentname, String email) {
		return isValidUser(studentname,email);
		}
	public boolean isValidUser(String studentname, String email){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/customers";
			Connection con = DriverManager.getConnection(url,"root","9ppropvl8");
			
			String query ="insert into studentinfo value(?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, studentname);
			pstmt.setString(2, email);
			
			pstmt.executeUpdate();  
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true ;
	}

	
}
