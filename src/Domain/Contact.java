package Domain;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class Contact implements Comparable<Contact> {

	private String username, name, surname, e_mail;
	private boolean blacklisted;
	private Address address = new Address();;
	private int messagesCount;

	/**
	 * constructor of the contact.Sets the username of the contact,
	 * Sets the contact as non blacklisted by default 
	 * and initializes the counter of the messages sent between the contact and the user.
	 * @param username , the username to be given to the contact
	 */
	public Contact(String username) {
		this.username = username;
		this.blacklisted = false;
		this.setMessagesCount(0);
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
		Contact other = (Contact) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return username;
	}

	@Override
	public int compareTo(Contact o) {
		return this.getUsername().compareTo(o.getUsername());
	}

	/**
	 * returns the number of messages sent between the contact and the user.
	 * @return the number of messages 
	 */
	public int getMessagesCount() {
		return messagesCount;
	}

	/**
	 * Sets the the number of messages sent.
	 * @param messagesCount , the new number of messages.
	 */
	public void setMessagesCount(int messagesCount) {
		this.messagesCount = messagesCount;
	}

	/**
	 * Sets the username of the contact.
	 * @param username ,the new username
	 */
	protected void setUsername(String username) {
		this.username = username;
	}

	/**
	 * increases the number of messages sent 
	 * between the contact and the user by some value.
	 * @param size , the value 
	 */
	public void incrementMessagesCount(int size) {
		setMessagesCount(messagesCount + size);
	}

	/**
	 * returns the name of the contact.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the contact.
	 * @param name ,the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the surname of the contact.
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname of the contact.
	 * @param surname ,the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * returns the e-mail of the contact.
	 * @return the e-mail
	 */
	public String getEmail() {
		return e_mail;
	}

	/**
	 * Sets the e-mail of the contact.
	 * @param e_mail , the new e-mail
	 */
	public void setEmail(String e_mail) {
		this.e_mail = e_mail;
	}

	/**
	 * returns true if the contact is blacklisted, else false.
	 * @return the blacklisted field's value
	 */
	public boolean isBlacklisted() {
		return blacklisted;
	}

	/**
	 * Sets the blacklisted field of the contact.
	 * @param blacklisted , the new blacklisted field's value
	 */
	public void setBlacklisted(boolean blacklisted) {
		this.blacklisted = blacklisted;
	}

	/**
	 * returns the address of the contact.
	 * @return the address
	 * @see Address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address of the contact.
	 * @param address , the new address
	 * @see Address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * returns the username of the contact.
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

}
