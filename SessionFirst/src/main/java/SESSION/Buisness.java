package SESSION;

public class Buisness {
	public boolean isValidUser(String user,String pass) {
		Connectivity con = new DatabaseConnetivity();
	    return con.isValid(user,pass);     
	}
}
