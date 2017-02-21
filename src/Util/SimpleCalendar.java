package Util;

import java.util.Calendar;

/**
 * Simple Calendar
 * 
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class SimpleCalendar implements Comparable<SimpleCalendar> {

	private Calendar date;

	/**
	 * Default constructor
	 * set current date to date
	 */
	public SimpleCalendar() {
		date = Calendar.getInstance();
	}

	/**
	 * Helper Constructor
	 * Define and set a date to date
	 * @param year year
	 * @param month month
	 * @param day day
	 */
	public SimpleCalendar(int year, int month, int day) {
		date = Calendar.getInstance();
		date.set(year, month - 1, day);
	}

	/**
	 * Helper Constructor
	 * Set date from passed parameter
	 * @param date date
	 */
	public SimpleCalendar(Calendar date) {
		this.date = date;
	}

	/**
	 * Return date's year
	 * @return year
	 */
	public int getYear() {
		return date.get(Calendar.YEAR);
	}

	/**
	 * Return date's month
	 * @return month
	 */
	public int getMonth() {
		return date.get(Calendar.MONTH) + 1;
	}

	/**
	 * Return date's day
	 * @return day
	 */
	public int getDay() {
		return date.get(Calendar.DAY_OF_MONTH);
	}

	public int compareTo(SimpleCalendar other) {
		return date.compareTo(other.date);
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		if (!(other instanceof SimpleCalendar))
			return false;
		SimpleCalendar theDate = (SimpleCalendar) other;
		if (date == null)
			return theDate.date == null;
		if (getYear() != theDate.getYear())
			return false;
		if (getMonth() != theDate.getMonth())
			return false;
		if (getDay() != theDate.getDay())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getDay() + "/" + getMonth() + "/" + getYear();
	}

}
