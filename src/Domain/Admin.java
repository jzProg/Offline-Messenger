package Domain;

/**
 * Administrator
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class Admin extends User {

	/**
	 * Constructor using superclass
	 * @param username username
	 * @param password password
	 */
	public Admin(String username, String password) {
		super(username, password);
	}

	/**
	 * Change a chatuser's username
	 * @param uname new username
	 * @param user user to apply change
	 */
	public void setChatUserUsername(String uname, User user) {
		user.setUsername(uname);
	}

	/**
	 * Change a chatuser's password
	 * @param pass new password
	 * @param user user to apply change
	 */
	public void setChatUserPassword(String pass, User user) {
		user.setPassword(pass);
	}

	@Override
	public String toString() {
		return "Admin : " + getUsername();
	}
	
	
}
