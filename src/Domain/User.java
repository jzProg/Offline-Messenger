package Domain;

/**
 * Users 
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class User {

	private String username, password;

	/**
	 * Constructor using username and password
	 * @param username username
	 * @param password password
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Return users username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set users username
	 * @param username username
	 */
	protected void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Return users password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set users password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Return true if passoword is valid 
	 * @param pass
	 * @return true if password equals to pass
	 */
	public boolean passwordIsValid(String pass) {
		return getPassword().equals(pass);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
