package DynamicWebAssignments;

public class BuisnessLayer {
	public boolean isValidUser(String cardNo,String from, String expiry, String cvv) {
		DataAccessLayer con = new DataPersistanceLayer();
	    return con.isValid(cardNo,from,expiry,cvv);
	    
	    }
}
