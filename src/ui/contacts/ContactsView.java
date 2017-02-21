package ui.contacts;

import java.util.List;

import ui.View;
import Domain.Contact;

/**
 * the view of the contacts window
 * @see ContactJFrame
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface ContactsView extends View{

	/**
	 * Sets the presenter of the view.
	 * @param contactsPresenter ,the new presenter
	 */
	void setPresenter(ContactsPresenter contactsPresenter);

	/**
	 * updates the contacts list.
	 * @param notBlacklistedContacts ,the new contacts list
	 */
	void setContacts(List<Contact> notBlacklistedContacts);

	/**
	 * returns the selected contact.
	 * @return the contact
	 */
	Contact getContact();

	/**
	 * returns the selected sort type.
	 * @return the sort type
	 */
	String getSortType();

	/**
	 * changes the selected contact.
	 * @param con , the new selected contact
	 */
	void setContact(Contact con);


}
