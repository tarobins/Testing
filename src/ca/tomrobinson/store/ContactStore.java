package ca.tomrobinson.store;

import ca.tomrobinson.contacts.Contact;

/**
 * A interface for a class that stores contacts.
 * 
 * @author trobinson
 *
 */
public interface ContactStore extends Iterable<Contact> {

	public void addContact(Contact contact);
	public void removeContact(Contact contact);
	
	/**
	 * Retrieve a contact with a given name.
	 * 
	 * @param name
	 * @return
	 */
	public Contact retrieveContact(String name);

}
