package ui.login;

import ui.ViewFactory;
import ui.admin.AdminPresenter;
import ui.mainApp.MainWindowPresenter;
import DAO.UserDAO;
import Domain.Admin;
import Domain.ChatUser;
import Domain.User;
import MemoryDAO.UserMDAO;

/**
 * Login presenter
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class LoginPresenter {

	User user;
	LoginView view;
	UserDAO userDao;

	/**
	 * Constructor with argument a login view 
	 * @param view
	 */
	public LoginPresenter(LoginView view) {
		user = null;
		this.view = view;
		userDao = new UserMDAO();
		view.setPresenter(this);
	}

	/**
	 * Login a user in the system if entered username and password are correct 
	 * @param username username
	 * @param password password
	 */
	public void loginUser(String username, String password) {
		setLoginUser(username, password);
		if (user == null) {
			view.showError("Username or password are incorrect");;
			start();
		} else {
			view.startApp();
		}
	}

	/**
	 * Find if user exists with given username and password
	 * @param username username
	 * @param password password
	 */
	public void setLoginUser(String username, String password) {

		if (username != null && password != null) {
			User u = userDao.find(username);
			if (u != null)
				if (u.passwordIsValid(password))
					user = u;
		}
	}

	/**
	 * Start an administrator presenter or a main window presenter if the user is 
	 * an administrator or chat user respectively 
	 */
	public void startAppForUser() {

		if (user instanceof ChatUser) {
			MainWindowPresenter p = new MainWindowPresenter(
					ViewFactory.createMainWindowJFrame());
			p.setUser((ChatUser) user);
			p.start();
		} else if (user instanceof Admin) {
			AdminPresenter p = new AdminPresenter((Admin) user,
					ViewFactory.createAdminJFrame());
			p.start();
		}
	}

	/**
	 * Open login view
	 */
	public void start() {
		view.open();
	}
	
	/**
	 * Return current user
	 * @return user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * return view
	 * @return view
	 */
	public LoginView getView() {
		return view;
	}
}
