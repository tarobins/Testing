package ca.tomrobinson.store;

import ca.tomrobinson.contacts.Contact;

public interface ContactStore {
	
	public void addContact(Contact contact);
	public void removeContact(Contact contact);
	public Contact retrieveContact(String name);

}
