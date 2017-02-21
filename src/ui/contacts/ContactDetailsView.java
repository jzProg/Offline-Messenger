package ui.contacts;

import ui.View;


/**
 * the view of contact details window
 * @see ContactDetailsJFrame
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface ContactDetailsView extends View{

	/**
	 * Sets the presenter of the view.
	 * @param contactDetailsPresenter
	 */
	void setPresenter(ContactDetailsPresenter contactDetailsPresenter);

	/**
	 * returns the text that represents the name of the contact.
	 * @return the name
	 */
	String getNameText();

	/**
	 * returns the text that represents the surname of the contact.
	 * @return the surname
	 */
	String getSurNameText();

	/**
	 * returns the text that represents the e-mail of the contact.
	 * @return the e-mail
	 */
	String getEmailText();

	/**
	 * returns the text that represents the country of the contact.
	 * @return the country
	 */
	String getCountryText();

	/**
	 * returns the text that represents the route of the contact.
	 * @return the route
	 */
	String getRouteText();

	/**
	 * returns the text that represents the number of the contact.
	 * @return the number
	 */
	String getNumberText();

	/**
	 * returns the text that represents the postal code of the contact.
	 * @return the postal code
	 */
	String getPostalText();

	/**
	 * Sets the name of the contact.
	 * @param name ,the new name
	 */
	void setNameText(String name);

	/**
	 * Sets the surname of the contact.
	 * @param surname ,the new surname
	 */
	void setSurNameText(String surname);

	/**
	 * Sets the e-mail of the contact.
	 * @param email , the new e-mail
	 */
	void setEmailText(String email);

	/**
	 * Sets the country of the contact.
	 * @param country ,the new country
	 */
	void setCountryText(String country);

	/**
	 * Sets the route of the contact.
	 * @param route ,the new route
	 */
	void setRouteText(String route);

	/**
	 * Sets the number of the contact.
	 * @param number ,the new number
	 */
	void setNumberText(int number);

	/**
	 * Sets the postal code of the contact.
	 * @param postalCode , the new postal code
	 */
	void setPostalText(int postalCode);
}
