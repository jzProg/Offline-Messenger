package ui.login;

import ui.View;

/**
 * Registration's View
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface RegistrationView extends View {

	/**
	 * Set this view's presenter class
	 * @param registrationPresenter presenter
	 */
	void setPresenter(RegistrationPresenter registrationPresenter);

	/**
	 * Returns the username given by the user
	 * @return username
	 */
	String getUsername();

	/**
	 * Returns the re-entered password by the user
	 * @return password1
	 */
	String getPassword1();

	/**
	 * Returns the password entered by the user
	 * @return password
	 */
	String getPassword();

	/**
	 * Start a Login view
	 */
	void startLogin();

}
