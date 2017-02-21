package ui.mainApp;

import java.util.Set;

import DAO.ConversationDAO;
import Domain.ChatUser;
import Domain.Conversation;
import MemoryDAO.ConversationMDAO;

/**
 * Main window presenter
 * 
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class MainWindowPresenter {

	ChatUser user;
	ConversationDAO convDao;
	MainWindowView view;

	/**
	 * Constructor with argument the main window view
	 * 
	 * @param view
	 *            main window view
	 */
	public MainWindowPresenter(MainWindowView view) {
		this.convDao = new ConversationMDAO();
		this.view = view;
		view.setPresenter(this);
	}

	/**
	 * Set conversations list of current user to view
	 */
	public void setUserConv() {
		Set<Conversation> l = convDao.findConvOfUser(user);
		view.setConvList(l);
	}

	/**
	 * Refresh and open view
	 */
	public void start() {
		update();
		view.open();
	}

	/**
	 * Update conversations list to view
	 */
	public void update() {
		setUserConv();
	}

	/**
	 * Delete a conversation from this user also remove him from this
	 * conversation
	 * 
	 * @param conv
	 */
	public void deleteConversation(Conversation conv) {
		user.removeConversation(conv);
		convDao.delete(conv);
	}

	/**
	 * Get current user
	 * @return user
	 */
	public ChatUser getUser() {
		return user;
	}

	/**
	 * Set current user
	 * @param user user
	 */
	public void setUser(ChatUser user) {
		this.user = user;
	}

}
