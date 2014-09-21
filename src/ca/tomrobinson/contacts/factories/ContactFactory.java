package ca.tomrobinson.contacts.factories;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;

public interface ContactFactory {
	public Contact createContact(String name, PhoneNumber phoneNumber);
	public PhoneNumber createPhone(String phone);
}
