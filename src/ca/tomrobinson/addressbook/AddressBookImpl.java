package ca.tomrobinson.addressbook;

import java.util.ArrayList;
import java.util.Collection;

import com.google.inject.Inject;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.dialer.Dialer;

public class AddressBookImpl implements AddressBook {
	
	private Collection<Contact> _contacts = new ArrayList<Contact>();
	private Dialer _dialer;
	
	@Inject
	public AddressBookImpl(Dialer dialer) {
		_dialer = dialer;
	}
	
	@Override
	public void add(Contact c) {
		_contacts.add(c);
	}
	
	@Override
	public PhoneNumber getHomePhone(String name) {
		for (Contact c:_contacts) {
			if (c.name().equals(name)) {
				return c.homePhone();
			}
		}
		
		return null;
	}

	@Override
	public void call(String name) {
		_dialer.dialNumber(getHomePhone(name));
	}
}
