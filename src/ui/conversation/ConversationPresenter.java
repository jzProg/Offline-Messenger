package ui.conversation;

import DAO.ConversationDAO;
import Domain.ChatUser;
import Domain.Conversation;
import Domain.Message;
import MemoryDAO.ConversationMDAO;
import Util.SimpleCalendar;

/**
 * Conversation presenter
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class ConversationPresenter {

	private ChatUser user;
	ConversationView view;
	private Conversation conv;
	ConversationDAO convDao;

	/**
	 * Constructor with argument a conversation view 
	 * @param view
	 */
	public ConversationPresenter(ConversationView view) {
		this.view = view;
		this.convDao = new ConversationMDAO();
		view.setPresenter(this);
	}

	/**
	 * Set conversation's messages to view
	 */
	public void setConvMessages() {
		view.setMessageList(getConv().getMessages());
	}

	/**
	 * Update and open view
	 */
	public void start() {
		update();
		view.open();
	}

	/**
	 * Refresh message list in view
	 */
	public void update() {
		setConvMessages();
	}

	/**
	 * Delete message from conversation
	 * @param message message 
	 */
	public void deleteMessage(Message message) {
		getConv().deleteMessage(message);

	}

	/**
	 * Send a new message as current user to this conversation
	 */
	public void sendMessage() {
		Message m = new Message(getUser().getUsername(), view.getMessage(),
				new SimpleCalendar());
		getConv().sendMessage(m);
		view.addMessageToList(m);
	}

	/**
	 * Set conversation
	 * @param conv conversation
	 */
	public void setConversation(Conversation conv) {
		this.conv = conv;
	}

	/**
	 * Set current user
	 * @param user current user
	 */
	public void setUser(ChatUser user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public ChatUser getUser() {
		return user;
	}

	/**
	 * @return the conv
	 */
	public Conversation getConv() {
		return conv;
	}



}
