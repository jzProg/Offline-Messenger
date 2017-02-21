package ui.contacts;

import java.util.List;

import ui.View;
import Domain.Contact;

/**
 * Contact selection view
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface ContactSelectionView extends View {

	/**
	 * Set contacts list
	 * @param list contacts list
	 */
	public void setContactsList(List<Contact> list);

	/**
	 * Get Selected contacts 
	 * @return list of selected contacts
	 */
	public List<Contact> getSelectedContacts();

	/**
	 * Set presenter
	 * @param contactSelectionPresenter contact selection presenter
	 */
	public abstract void setPresenter(
			ContactSelectionPresenter contactSelectionPresenter);

}