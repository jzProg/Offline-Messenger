package ui.conversation;

import ui.View;

/**
 * New message view
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface NewMessageView extends View {

	/**
	 * Returns the message entered by the user
	 * @return
	 */
	public String getMessage();

	/**
	 * Sets a presenter to the view
	 * @param newMessagePresenter message presenter
	 */
	public void setPresenter(NewMessagePresenter newMessagePresenter);

	
}
