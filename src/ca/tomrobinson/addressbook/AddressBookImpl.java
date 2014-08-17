package ca.tomrobinson.addressbook;

import java.util.ArrayList;
import java.util.Collection;

import com.google.inject.Inject;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.store.ContactStore;

public class AddressBookImpl implements AddressBook {
	
	private ContactStore _store;
	private Dialer _dialer;
	
	@Inject
	public AddressBookImpl(Dialer dialer, ContactStore store) {
		_dialer = dialer;
		_store = store;
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
