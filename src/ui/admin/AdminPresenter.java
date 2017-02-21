package ui.admin;

import java.util.Set;

import DAO.UserDAO;
import Domain.Admin;
import Domain.ChatUser;
import Domain.User;
import MemoryDAO.UserMDAO;

/**
 * Administrator presenter
 * 
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class AdminPresenter {

	Admin admin;
	AdminView view;
	UserDAO userdao;

	/**
	 * Constructor
	 * 
	 * @param admin
	 *            administrator
	 * @param view
	 *            administrator view
	 */
	public AdminPresenter(Admin admin, AdminView view) {
		this.admin = admin;
		this.view = view;
		this.userdao = new UserMDAO();
		view.setPresenter(this);
	}

	/**
	 * Update and open administrator view
	 */
	public void start() {
		update();
		view.open();
	}

	/**
	 * Refresh users list
	 */
	public void update() {
		Set<User> set = userdao.findAll();
		set.remove(admin);
		view.setUserList(set);
	}

	/**
	 * Delete user from external data store and view list
	 * 
	 * @param user
	 *            user
	 */
	public void deleteUser(User user) {
		if (user instanceof ChatUser) {
			((ChatUser) user).removeAllConversations();
		}
		userdao.delete(user);
		update();
	}

	/**
	 * Change username of selected user
	 * 
	 * @param user
	 *            user
	 */
	public void changeUserUsername(User user) {
		if (view.getUsername() == null || view.getUsername().trim().equals(""))
			view.showError("Username cannot be blanc");
		else
			admin.setChatUserUsername(view.getUsername(), user);

	}

	/**
	 * change password of selected user
	 * 
	 * @param user
	 *            user
	 */
	public void changeUserPassword(User user) {
		if (view.getPassword() == null || view.getPassword().length() < 8)
			view.showError("Password must be at least 8 characters long");
		else
			admin.setChatUserPassword(view.getPassword(), user);

	}

	/**
	 * Return administrator
	 * @return administrator
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * Return administrator view
	 * @return administrator view
	 */
	public AdminView getView() {
		return view;
	}
}
