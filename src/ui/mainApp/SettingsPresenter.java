package ui.mainApp;

import Domain.ChatUser;

/**
 * the presenter of the settings window
 * @see SettingJFrame
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class SettingsPresenter {
	
	private SettingsView view;
	private ChatUser user;
	
	
	/**
	 * the constructor of the presenter.Sets the view.
	 * @param view ,a Settings view
	 */
	public SettingsPresenter(SettingsView view){
		this.view = view;
	}
	
	/**
	 * initializes the view's presenter,profile picture(using active user) and opens the view.
	 */
	public void start() {
        view.setPresenter(this);
        view.setImage(user.getProfileImg());
        view.open();     
    }


	/**
	 * changes user's profile picture(using the view).
	 */
	public void setprofilepicture() {
			user.setProfileImg(view.getImage());
	}


	/**
	 * changes user's password(using the view).
	 */
	public void setNewPassword() {
		user.setPassword(view.getPassword());
		
	}

	/**
	 * Sets the active user.
	 * @param user ,the new active user
	 */
	public void setUser(ChatUser user) {
		this.user = user;
	}

	/**
	 * returns the active user.
	 * @return the user
	 */
	public ChatUser getUser() {
		return user;
	}

	/**
	 * checks if the given password matches the user's password.
	 * @param pass , the given password
	 * @return 0 in case it matches,1 in case it doesn't and -1 in case of null given password
	 */
	public int OldPasswordConfirm(String pass){
		if (pass == null) return -1;
		if (pass.equals(user.getPassword())) return 0;
		return 1;
	}

}
