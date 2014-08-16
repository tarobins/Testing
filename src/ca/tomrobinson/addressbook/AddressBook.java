package ca.tomrobinson.addressbook;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;

public interface AddressBook {

	public PhoneNumber getHomePhone(String name);
	public void call(String name);

	public void add(Contact c);

}
