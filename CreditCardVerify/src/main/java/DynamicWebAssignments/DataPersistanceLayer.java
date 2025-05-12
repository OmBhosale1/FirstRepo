package DynamicWebAssignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class DataPersistanceLayer implements DataAccessLayer{

	public boolean isValid(String CardNo, String from, String expiry, String cvv) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/customers";
			
			Connection con= DriverManager.getConnection(url,"root","9ppropvl8");
			
			String query = "select * from CCDb where CardNumber=? and DateFrom=? and DateExpiry=? and CVV=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,CardNo);
			pstmt.setString(2,from);
			pstmt.setString(3,expiry);
			pstmt.setString(4,cvv);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() == true) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;   
	}
}
