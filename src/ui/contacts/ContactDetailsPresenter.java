package ui.contacts;

import Domain.Contact;

/**
 * the presenter of the contact details window
 * @see ContactDetailsJFrame
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class ContactDetailsPresenter {
	
	ContactDetailsView view;
	Contact con;

	/**
	 * the constructor.Sets the view and the contact fields.
	 * @param view , a contact details view
	 * @param con  , the selected contact
	 */
	public ContactDetailsPresenter(ContactDetailsView view,Contact con){
		this.view = view;
		this.con = con;
	}
	
	/**
	 * initializes the view's presenter and text fields and opens the view.
	 */
	public void start() {
        view.setPresenter(this);
        view.setNameText(con.getName());
        view.setSurNameText(con.getSurname());
        view.setEmailText(con.getEmail());
        view.setCountryText(con.getAddress().getCountry());
        view.setRouteText(con.getAddress().getRoute());
        view.setNumberText(con.getAddress().getNumber());
        view.setPostalText(con.getAddress().getPostalCode());
        view.open(); 
    }

	/**
	 * updates the selected contact's name (using the view)
	 */
	public void setName() {
		con.setName(view.getNameText());
	}
	
	/**
	 * updates the selected contact's surname (using the view)
	 */
	public void setSurName() {
		con.setSurname(view.getSurNameText());
	}
	
	/**
	 * updates the selected contact's e-mail (using the view)
	 */
	public void setEmail() {
		con.setEmail(view.getEmailText());
	}
	
	/**
	 * updates the selected contact's country (using the view)
	 */
	public void setCountry() {
		con.getAddress().setCountry(view.getCountryText());
	}
	
	/**
	 * updates the selected contact's route (using the view)
	 */
	public void setRoute() {
		con.getAddress().setRoute(view.getRouteText());
	}
	
	/**
	 * updates the selected contact's number (using the view)
	 */
	public void setNumber() {
		con.getAddress().setNumber(Integer.parseInt(view.getNumberText()));
	}
	
	/**
	 * updates the selected contact's postal code (using the view)
	 */
	public void setPostal() {
		con.getAddress().setPostalCode(Integer.parseInt(view.getPostalText()));
	}
	
	
	/**
	 * Get contact
	 * @return contact
	 */
	public Contact getCon() {
		return con;
	}
}
