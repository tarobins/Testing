package ca.tomrobinson.guicemodule;

import java.util.ArrayList;
import java.util.Collection;

import ca.tomrobinson.addressbook.AddressBook;
import ca.tomrobinson.addressbook.AddressBookImpl;
import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.ContactFactory;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.contacts.SimpleContact;
import ca.tomrobinson.contacts.SimplePhoneNumber;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.dialer.PrintScreenDialer;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class CommandLineAddressBookModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(AddressBook.class).to(AddressBookImpl.class);
		bind(Dialer.class).to(PrintScreenDialer.class);
		
		install(new FactoryModuleBuilder()
				.implement(Contact.class, SimpleContact.class)
				.implement(PhoneNumber.class, SimplePhoneNumber.class)
				.build(ContactFactory.class));
		
	}
	
	@Provides
	Collection<Contact> provideContactCollection() {
		return new ArrayList<Contact>();
	}
	
	

}
