package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.ImageIcon;

import Util.ContactPopularityComparator;
import Util.MessengerException;

/**
 * Chat user
 * @author John
 *
 */
/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class ChatUser extends User {

	private ImageIcon profileImg;
	private SortedSet<Contact> contacts = new TreeSet<Contact>();
	private Set<Conversation> conversations = new HashSet<Conversation>();

	/**
	 * Constructor using superclass
	 * @param username username
	 * @param password password
	 */
	public ChatUser(String username, String password) {
		super(username, password);
	}

	/**
	 * Create a new conversation with the users passed in the set
	 * @param set set of users
	 * @return the created conversation
	 */
	public Conversation createNewConversation(Set<ChatUser> set) {
		Conversation c = new Conversation();
		set.add(this);
		c.addUsers(set);
		c.addConversationToUsers();
		addConversation(c);
		return c;
	}

	/**
	 * Send a message to given conversation
	 * @param conv conversation
	 * @param text text of message
	 */
	public void sendMessage(Conversation conv, String text) {
		if (!conversations.contains(conv))
			throw new MessengerException();
		conv.sendMessage(getUsername(), text);
	}

	/**
	 * Sort contacts by popularity
	 * @return List of sorted contacts
	 */
	public List<Contact> getContactsSortedByPopularity() {

		for (Contact c : contacts)
			if (!c.isBlacklisted())
				for (Conversation conv : conversations)
					for (ChatUser u : conv.getReceivers())
						if (u.getUsername().equals(c.getUsername()))
							c.incrementMessagesCount(conv.getMessages().size());

		List<Contact> tmp = new ArrayList<Contact>(getNotBlacklistedContacts());
		Collections.sort(tmp, new ContactPopularityComparator());
		return tmp;
	}

	/**
	 * Returns a list of the blacklisted contacts
	 * @return list of blacklisted contacts
	 */
	public List<Contact> getBlacklistedContacts() {
		List<Contact> tmp = new ArrayList<Contact>();
		for (Contact cont : contacts)
			if (cont.isBlacklisted())
				tmp.add(cont);
		return tmp;
	}

	/**
	 * Returns a list of the non blacklisted contacts
	 * @return list of non blacklisted contacts
	 */
	public List<Contact> getNotBlacklistedContacts() {
		List<Contact> tmp = new ArrayList<Contact>();
		for (Contact cont : contacts)
			if (!cont.isBlacklisted())
				tmp.add(cont);
		return tmp;
	}

	/**
	 * Create and add a new contact with given username
	 * @param username username 
	 * @return false if contact exists
	 */
	public boolean createNewContact(String username) {
		if (username == null)
			return false;
		return contacts.add(new Contact(username));
	}

	/**
	 * Add given contact if doesn't already exist 
	 * @param c contact
	 * @return false if contact exists
	 */
	public boolean addContact(Contact c) {
		if (c == null)
			return false;
		return contacts.add(c);
	}

	/**
	 * Remove contact from list if exists
	 * @param c contact to be removed
	 * @return false if contact doesn't exist or given reference is null 
	 */
	public boolean removeContact(Contact c) {
		if (c == null)
			return false;
		return contacts.remove(c);
	}

	/**
	 * Remove a conversation from this user, 
	 * throw exception if conversation doesn't contain this user
	 * @param conv conversation
	 */
	public void removeConversation(Conversation conv) {
		if (conversations.remove(conv))
			conv.removeReceiver(this);
		else
			throw new MessengerException(
					"conversation does not belong to this user");
	}

	/**
	 * Remove user from all conversations and clear conversations list
	 */
	public void removeAllConversations() {
		for (Conversation c : conversations)
			c.removeReceiver(this);
		conversations.clear();
	}

	/**
	 * Delete a message from a conversation that belongs to this user
	 * throw exception otherwise
	 * @param conv conversation
	 * @param message message to be deleted
	 */
	public void deleteMessageFromConv(Conversation conv, Message message) {
		if (!conversations.contains(conv))
			throw new MessengerException(
					"conversation does not belong to this user");
		conv.deleteMessage(message);

	}

	/**
	 * Add a conversation to the list 
	 * @param conversation conversation
	 * @return false if conversation is null or already exists
	 */
	public boolean addConversation(Conversation conversation) {
		if (conversation == null)
			return false;
		return conversations.add(conversation);
	}

	/**
	 * Add given contact to blacklist
	 * (mark as blacklisted)
	 * @param c contact
	 */
	public void addToBlacklist(Contact c) {
		c.setBlacklisted(true);
	}

	/**
	 * Remove given contact from blacklist
	 * (mark as  not blacklisted)
	 * @param c contact
	 */
	public void removeFromBlacklist(Contact c) {
		c.setBlacklisted(false);
	}

	/**
	 * Return profile image
	 * @return profile image
	 */
	public ImageIcon getProfileImg() {
		return profileImg;
	}
	
	/**
	 * Set profile image
	 * @param pic profile image
	 */
	public void setProfileImg(ImageIcon pic) {
		this.profileImg = pic;
	}

	/**
	 * Return all contacts 
	 * @return all contacts sorted set
	 */
	public SortedSet<Contact> getContacts() {
		return contacts;
	}

	/**
	 * Set all contacts 
	 * @param contacts all contacts sorted set
	 */
	public void setContacts(SortedSet<Contact> contacts) {
		this.contacts = contacts;
	}

	/**
	 * Return the set of conversations
	 * @return conversations set
	 */
	public Set<Conversation> getConversations() {
		return conversations;
	}

	/**
	 * Set the conversations set
	 * @param conversations conversations set
	 */
	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return getUsername();
	}

}
