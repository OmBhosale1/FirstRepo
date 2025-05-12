package DynamicWebAssignments;


public interface DataAccessLayer {

	boolean isValid(String cardNo, String from , String expiry , String cvv);
	
}
