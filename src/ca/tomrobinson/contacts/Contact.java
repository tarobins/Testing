package ca.tomrobinson.contacts;

/**
 * A model for a contact.
 * 
 * @author trobinson
 *
 */
public interface Contact {
	
	/**
	 * @return the contact's name
	 */
	public String name();
	
	/**
	 * @return the contact's phone number
	 */
	public PhoneNumber phone();
}
