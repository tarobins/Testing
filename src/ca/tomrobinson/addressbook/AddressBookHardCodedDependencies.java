package ca.tomrobinson.addressbook;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.dialer.BigHeavyDialer;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.HashMapContactStore;

public class AddressBookHardCodedDependencies implements AddressBook {
	
	private ContactStore _store;
	private Dialer _dialer;
	
	public AddressBookHardCodedDependencies() {
		_dialer = new BigHeavyDialer(); 
		_store = new HashMapContactStore();
	}
	
	@Override
	public void add(Contact c) {
		_store.addContact(c);
	}
	
	@Override
	public PhoneNumber getHomePhone(String name) {
		return _store.retrieveContact(name).phone();
	}

	@Override
	public void call(String name) {
		_dialer.dialNumber(getHomePhone(name));
	}
}
