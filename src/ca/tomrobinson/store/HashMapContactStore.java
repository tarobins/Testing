package ca.tomrobinson.store;

import java.util.HashMap;
import java.util.Iterator;

import ca.tomrobinson.contacts.Contact;

public class HashMapContactStore implements SerializableContactStore {

	private static final long serialVersionUID = 1L;
	
	HashMap<String, Contact> _map = new HashMap<String, Contact>();
	
	@Override
	public void addContact(Contact contact) {
		_map.put(contact.name(), contact);
	}

	@Override
	public void removeContact(Contact contact) {
		_map.remove(contact.name(), contact);
	}

	@Override
	public Contact retrieveContact(String name) {
		return _map.get(name);
	}

	@Override
	public Iterator<Contact> iterator() {
		return _map.values().iterator();
	}

}
