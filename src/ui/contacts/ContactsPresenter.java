package ui.contacts;


import ui.ViewFactory;
import DAO.UserDAO;
import Domain.ChatUser;
import Domain.Contact;
import MemoryDAO.UserMDAO;

/**
 * the presenter of the contacts window.
 * @see ContactJFrame
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class ContactsPresenter {

	UserDAO userdao;
	private ContactsView view;
	private ChatUser user;


	/**
	 * the constructor of the presenter.
	 * Sets the view,the user and initializes the userdao.
	 * @param view ,a contacts view
	 * @param user ,the active user
	 */
	public ContactsPresenter(ContactsView view,ChatUser user){
		this.view = view;
		this.user = user;
		userdao = new UserMDAO();
	}

	/**
	 * initializes the view's presenter,contacts list and opens the view.
	 */
	public void start() {
		view.setPresenter(this);
		setContactList(null);
		view.open(); 
	}

	/**
	 * updates the view's contacts list using the user's list 
	 * sorted by given sort type (alphabetically or by popularity).
	 * @param sortType , the sort type
	 */
	public void setContactList(String sortType) {
		if(sortType == null ||sortType.equals("Alphabetically")){
			view.setContacts(user.getNotBlacklistedContacts());
		}
		else {
			view.setContacts(user.getContactsSortedByPopularity());
		}
	}

	/**
	 * adds a new contact to user's list with the given username 
	 * and updates the view's list
	 * @param username , the given username of the new contact
	 */
	public void addContactToList(String username) {
		if(username!=null){
			ChatUser user2 = (ChatUser) userdao.find(username);
			if(user2!=null){
				Contact con=new Contact(username);
				user.addContact(con);
				setContactList(view.getSortType());
			}
			else 
				view.showError("User does not exist");
		}
		else 
			view.showError("Insert a valid username");
	}

	/**
	 * Sets the active user.
	 * @param user , the new active user
	 */
	public void setUser(ChatUser user){
		this.user = user;
	}

	/**
	 * returns the active user
	 * @return the user
	 */
	public ChatUser getUser(){
		return user;
	}

	/**
	 * opens a contacts details window in order for the user to edit the selected contact's info
	 * and updates the view's contacts list.
	 * @see ContactDetailsView
	 * @see ContactDetailsPresenter
	 * @see ViewFactory
	 */
	public void editContact() {
		ContactDetailsView inst = ViewFactory.createContactDetailsJFrame();
		ContactDetailsPresenter cdPresenter = new ContactDetailsPresenter(inst,view.getContact());
		cdPresenter.start();
		setContactList(view.getSortType());
	}

	/**
	 * removes the selected contact from the user's list(using the view)
	 * and updates the view's contacts list.
	 */
	public void deleteContact() {
		user.removeContact(view.getContact());
		setContactList(view.getSortType());
	}

	/**
	 * adds the selected contact to user's black list(using the view)
	 * and updates the view's contacts list.
	 */
	public void addBL() {
		user.addToBlacklist(view.getContact());
		setContactList(view.getSortType());
	}

}
