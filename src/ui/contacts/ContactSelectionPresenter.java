package ui.contacts;

import java.util.List;

import Domain.ChatUser;
import Domain.Contact;

/**
 * Contact selection presenter
 * 
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class ContactSelectionPresenter {

	ContactSelectionView view;
	ChatUser user;
	List<Contact> selectedContacts;

	/**
	 * Constructor with argument a contact selection view
	 * 
	 * @param view
	 *            contact selection view
	 */
	public ContactSelectionPresenter(ContactSelectionView view) {
		this.view = view;
		this.view.setPresenter(this);
	}

	/**
	 * Set current user
	 * 
	 * @param user
	 *            user
	 */
	public void setUser(ChatUser user) {
		this.user = user;
	}

	/**
	 * Set contact list to view
	 */
	public void setContacts() {
		view.setContactsList(user.getNotBlacklistedContacts());
	}

	/**
	 * Get selected contacts list
	 * 
	 * @return list of selected contacts
	 */
	public List<Contact> getSelectedContacts() {
		return selectedContacts;
	}

	/**
	 * Set selected contacts list
	 * 
	 * @param selectedContacts
	 */
	public void setSelectedContacts(List<Contact> selectedContacts) {
		this.selectedContacts = selectedContacts;
	}

	/**
	 * set contacts list and Open view 
	 */
	public void start() {
		setContacts();
		view.open();
	}

	/**
	 * Get current user
	 * @return user
	 */
	public ChatUser getUser() {
		return user;
	}
}
