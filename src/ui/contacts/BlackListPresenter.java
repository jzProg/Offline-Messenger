package ui.contacts;

import Domain.ChatUser;
import Domain.Contact;

/**
 * the presenter of the blacklist window
 * @see BlackListJFrame
 * @author Vlassis Ioannis, Zagarelos Ioannis
 */
public class BlackListPresenter {

	private BlackListView view;
	ChatUser user;
	
	/**
	 * the constructor of the class
	 * @param view ,a blacklist view
	 * @param user ,the active chat user
	 */
	public BlackListPresenter(BlackListView view,ChatUser user){
		this.view = view;
		this.user = user;
	}
	
	/**
	 * sets the presenter , initialize the black list and opens the view
	 */
	public void start() {
        view.setPresenter(this);
        getBlackList();
        view.open(); 
    }
	
	/**
	 * updates the black list of the view
	 */
	public void getBlackList(){
	    view.setBLContactList(user.getBlacklistedContacts());
	}

	/**
	 * returns the active user
	 * @return the active user
	 */
	public ChatUser getUser() {
		return user;
	}

	/**
	 * deletes a contact from black list (using the view's contact field)
	 */
	public void deleteBlContact() {
		user.removeFromBlacklist(view.getBLContact());
		getBlackList();
	}
	
	/**
	 * returns the selected contact
	 * @return the view's contact field
	 */
	public Contact getContact(){
		return view.getBLContact();
	}
	
}
