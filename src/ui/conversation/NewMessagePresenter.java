package ui.conversation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ui.mainApp.MainWindowPresenter;
import DAO.ConversationDAO;
import DAO.UserDAO;
import Domain.ChatUser;
import Domain.Contact;
import Domain.Conversation;
import MemoryDAO.ConversationMDAO;
import MemoryDAO.UserMDAO;

/**
 * New message presenter
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class NewMessagePresenter {

	ChatUser user;
	NewMessageView view;
	List<Contact> contactsToSend;
	private MainWindowPresenter mainPresenter;
	
	/**
	 * Constructor with argument a new message view
	 * @param view new message view
	 */
	public NewMessagePresenter(NewMessageView view) {
		this.view = view;
		this.view.setPresenter(this);
	}

	/**
	 * Open the view
	 */
	public void start(){
		view.open();
	}
	
	/**
	 * Set current user
	 * @param user user
	 */
	public void setUser(ChatUser user) {
		this.user = user;
	}
	
	/**
	 * Get current user
	 * @return user
	 */
	public ChatUser getUser() {
		return user;
	}
	
	/**
	 * Set list of contacts to send message
	 * @param contactsToSend list of contacts
	 */
	public void setContactsToSend(List<Contact> contactsToSend) {
		this.contactsToSend = contactsToSend;
	}
	
	/**
	 * Create a new conversation with receivers the selected contacts 
	 * and send a message from current user with text entered in view
	 */
	public void sendMessage(){
		if (contactsToSend==null || contactsToSend.isEmpty()){
			view.showError("Select contacts to send message");
			return;
		}
		String text=view.getMessage();
		Conversation conv =user.createNewConversation(getUsersFromSelectedContacts());
		user.sendMessage(conv, text);
		ConversationDAO cdao= new ConversationMDAO();
		cdao.save(conv);
		mainPresenter.update();
		view.close();
	}
	
	/**
	 * Find users reference from contacts' username and return a set these users  
	 * @return set of users
	 */
	private Set<ChatUser> getUsersFromSelectedContacts(){
		UserDAO udao =new UserMDAO();
		Set<ChatUser> users = new HashSet<ChatUser>();
		for (Contact c: contactsToSend)
			users.add((ChatUser) udao.find(c.getUsername()));
		return users;
		
	}
	
	/**
	 * Set A main presenter
	 * @param mainPresenter main presenter
	 */
	public void setMainPresenter(MainWindowPresenter mainPresenter) {
		this.mainPresenter = mainPresenter;
	}
}
