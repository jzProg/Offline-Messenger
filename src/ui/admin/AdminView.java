package ui.admin;

import java.util.Set;

import ui.View;
import Domain.User;

/**
 * Administrator view
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface AdminView extends View {

	/**
	 * Set users list
	 * @param users users list
	 */
	void setUserList(Set<User> users);

	/**
	 * Set presenter
	 * @param adminPresenter admin presenter
	 */
	void setPresenter(AdminPresenter adminPresenter);

	/**
	 * Get edited username of selected user
	 * @return username
	 */
	String getUsername();

	/**
	 * Get edited password of selected user
	 * @return password
	 */
	String getPassword();
	
	
}
