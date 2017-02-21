package ui.conversation;

import java.util.List;

import ui.View;
import Domain.Message;

/**
 * Conversation view
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface ConversationView extends View {

	/**
	 * Get message to send
	 * @return message
	 */
	public String getMessage();

	/**
	 * Set messages list to view
	 * @param messages message list
	 */
	public void setMessageList(List<Message> messages);

	/**
	 * Set presenter to view
	 * @param presenter conversation presenter
	 */
	public void setPresenter(ConversationPresenter presenter);

	/**
	 * Add sent message to view list
	 * @param m message
	 */
	void addMessageToList(Message m);

}
