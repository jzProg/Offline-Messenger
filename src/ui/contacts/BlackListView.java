package ui.contacts;

import java.util.List;

import ui.View;
import Domain.Contact;

/**
 * the view of the black list window
 * @see BlackListJFrame
 * @author Vlassis Ioannis, Zagarelos Ioannis
 */
public interface BlackListView extends View{

	/**
	 * Sets the presenter of blacklist view
	 * @param blackListPresenter
	 * @see BlackListPresenter
	 */
	void setPresenter(BlackListPresenter blackListPresenter);

	/**
	 * Sets the list that contains the black-listed contacts
	 * @param blacklistedContacts
	 * @see Contact
	 */
	void setBLContactList(List<Contact> blacklistedContacts);

	/**
	 * returns the contact field of the blacklist view
	 * @return the blacklisted contact
	 * @see Contact
	 */
	Contact getBLContact();

	/**
	 * Sets the contact field of the blacklist view
	 * @param con
	 * @see Contact
	 */
	void setBLContact(Contact con);
	
}
