package ui.login;

import ui.View;

/**
 * Login view
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface LoginView extends View {

	/**
	 * Get entered password
	 * @return password
	 */
	public String getPassword();

	/**
	 * Get entered username
	 * @return username
	 */
	public String getUsername();

	/**
	 * Start application for either administrator or chat user
	 */
	public void startApp();

	/**
	 * Set presenter to this view
	 * @param loginUIPresenter login presenter
	 */
	public void setPresenter(LoginPresenter loginUIPresenter);
}