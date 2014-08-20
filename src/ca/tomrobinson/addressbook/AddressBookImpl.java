package ca.tomrobinson.addressbook;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.guicemodule.DefaultStore;
import ca.tomrobinson.store.ContactStore;

import com.google.inject.Inject;

public class AddressBookImpl implements AddressBook {
	
	private ContactStore _store;
	private Dialer _dialer;
	
	@Inject
	public AddressBookImpl(Dialer dialer, @DefaultStore ContactStore store) {
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
