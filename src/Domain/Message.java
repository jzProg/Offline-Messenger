package Domain;

import Util.SimpleCalendar;

/**
 * Message
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class Message {

	private static int idCount = 0;
	private int ID;
	private String text;
	private SimpleCalendar date;
	private String sender;

	/**
	 * Default constructor, increment  id count and 
	 * set this message's id
	 */
	public Message() {
		ID = idCount;
		idCount++;
	}

	/**
	 * Helper constructor, 
	 * set a sender, text and date for this message
	 * @param sender sender's username
	 * @param text text of message
	 * @param date sending date
	 */
	public Message(String sender, String text, SimpleCalendar date) {
		this();
		this.sender = sender;
		this.text = text;
		this.date = date;
	}

	/**
	 * Reset id count to 0
	 */
	public static void resetIdCount() {
		Message.idCount = 0;
	}


	/**
	 * Return sender's username
	 * @return sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Set sender's username
	 * @param sender sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * Return message's id
	 * @return id
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Get message's text
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set message's text
	 * @param text text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get date of message
	 * @return date 
	 */
	public SimpleCalendar getDate() {
		return date;
	}

	/**
	 * Set date of message
	 * @param date date
	 */
	public void setDate(SimpleCalendar date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "<html>"+date.toString() + "   From: " + sender + ":<br/>" + text
				+ "<br/><html/>";
	}

	@Override
	public int hashCode() {
		final int prime = 1;
		int result = 1;
		result = prime * result + ID;
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
		Message other = (Message) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
}
