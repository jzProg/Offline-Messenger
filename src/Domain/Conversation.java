package Domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Util.SimpleCalendar;

/**
 * Conversations
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class Conversation {

	private static int idCount = 0;
	private int ID;
	private List<Message> messages=new LinkedList<Message>();
	private Set<ChatUser> receivers = new HashSet<ChatUser>();

	/**
	 * Default constructor, increment  id count and 
	 * set this conversation's id
	 */
	public Conversation() {
		ID = idCount;
		idCount++;
	}

	/**
	 * Add users as receivers to the conversation
	 * @param u users set
	 */
	public void addUsers(Set<ChatUser> u) {
		receivers.addAll(u);
	}

	/**
	 * For every user in the receivers set, add this conversation 
	 * to their conversations set
	 */
	public void addConversationToUsers() {
		for (ChatUser u : receivers)
			u.addConversation(this);

	}

	/**
	 * Add a new message to message list
	 * @param sender username of sender 
	 * @param text text of message
	 */
	public void sendMessage(String sender, String text) {
		if (text != null && sender != null)
			messages.add(new Message(sender, text, new SimpleCalendar()));
	}

	/**
	 * Add given message to message list if not null
	 * @param m message
	 */
	public void sendMessage(Message m) {
		if (m != null)
			messages.add(m);
	}

	/**
	 * Return a copy of messages list
	 * @return message list
	 */
	public List<Message> getMessages() {
		return new LinkedList<Message>(messages);
	}

	/**
	 * Set the messages list
	 * @param messages messages list
	 */
	protected void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	/**
	 * Return id of conversation
	 * @return id
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Return a copy or the users in this conversation
	 * @return set of users
	 */
	public Set<ChatUser> getReceivers() {
		return new HashSet<ChatUser>(receivers);
	}

	/**
	 * Set the receivers set
	 * @param receivers receivers set
	 */
	protected void setReceivers(Set<ChatUser> receivers) {
		this.receivers = receivers;
	}

	/**
	 * Remove user from receiver set
	 * @param chatUser user to be removed
	 * @return true if user removed successfully
	 */
	public boolean removeReceiver(ChatUser chatUser) {
		return receivers.remove(chatUser);
	}

	/**
	 * Delete message from messages list
	 * @param message message to be removed
	 * @return true if message removed successfully
	 */
	public boolean deleteMessage(Message message) {
		return messages.remove(message);
	}

	/**
	 * Reset id count to 0
	 */
	public static void resetIdCount() {
		Conversation.idCount = 0;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result += ID;
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
		Conversation other = (Conversation) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return receivers.toString();
	}

}
