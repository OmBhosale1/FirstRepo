package DynamicWebAssignments;

public class BuisnessLayer1 {

	public boolean isValidUser(String studentname ,String email) {
		DataAccessLayer dal = new DataPersistanceLayer1();
		return dal.isValid(studentname, email);
	}
	public void insert(String studentname ,String email) {
		DataAccessLayer dal = new DataPersistance2();
		dal.isValid(studentname, email);
	}
	
	
}
