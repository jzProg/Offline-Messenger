package Domain;

/**
 * the address of the user
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class Address {

	private String route, country;
	private int number, postal_code;

	/**
	 * default constructor
	 */
	public Address() {
	}
    
	/**
	 * helper constructor.Sets the route,country,number,postal_code fields.
	 * @param route , new route
	 * @param country ,new country
	 * @param number  ,new number
	 * @param postal_code , new postal code
	 */
	public Address(String route, String country, int number, int postal_code) {
		this.route = route;
		this.country = country;
		this.number = number;
		this.postal_code = postal_code;
	}

	/**
	 * returns the route
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * changes the route's value
	 * @param route , the new route
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * returns the country
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * changes the country's value
	 * @param country ,the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * returns the number
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * changes the number's value
	 * @param number ,the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * returns the postal code
	 * @return the postal code
	 */
	public int getPostalCode() {
		return postal_code;
	}

	/**
	 * changes the postal code's value
	 * @param postal_code , the new postal code
	 */
	public void setPostalCode(int postal_code) {
		this.postal_code = postal_code;
	}
}
