package DynamicWebAssignments;

public class DataPersistanceLayer1 implements DataAccessLayer {

	@Override
	public Boolean isValid(String studentname, String email) {
		
		return isValidDP(studentname,email) ;
	}
	
	public Boolean isValidDP(String studentname, String email){
		if (studentname == null || studentname.trim().isEmpty() || !email.contains("@")) return true ;
		else return false ;
			
    }
	
	
}
