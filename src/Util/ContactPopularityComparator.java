package Util;


import java.util.Comparator;

import Domain.Contact;

/**
 * Comperator for contacts popularity
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public class ContactPopularityComparator implements Comparator<Contact> {

	public int compare(Contact o1, Contact o2) {
		
		if (o1.getMessagesCount() > o2.getMessagesCount()) return -1;
		else if (o1.getMessagesCount() < o2.getMessagesCount()) return 1;
		return o1.compareTo(o2);
	}

}
