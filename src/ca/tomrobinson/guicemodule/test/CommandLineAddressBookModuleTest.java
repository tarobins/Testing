package ca.tomrobinson.guicemodule.test;

import org.junit.Before;
import org.junit.Test;

import ca.tomrobinson.addressbook.AddressBook;
import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.contacts.factories.ContactFactory;
import ca.tomrobinson.guicemodule.CommandLineAddressBookModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CommandLineAddressBookModuleTest {

	Injector _injector;
	
	@Before
	public void setUp() {
		_injector = Guice.createInjector(new CommandLineAddressBookModule());
	}
	
	@Test
	public void testAddressBookCreation() {
		AddressBook book = _injector.getInstance(AddressBook.class);
	}
	
	@Test
	public void testContactFactory() {
		ContactFactory contactFactory = _injector.getInstance(ContactFactory.class);
		
		PhoneNumber n = contactFactory.createPhone("405");
		Contact c = contactFactory.createContact("Tom", n);
	}

}
