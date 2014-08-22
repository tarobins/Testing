package ca.tomrobinson.guicemodule;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.ContactFactory;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.contacts.SimpleContact;
import ca.tomrobinson.contacts.SimplePhoneNumber;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class ContactModule extends AbstractModule {


	@Override
	protected void configure() {
		install(new FactoryModuleBuilder()
				.implement(Contact.class, SimpleContact.class)
				.implement(PhoneNumber.class, SimplePhoneNumber.class)
				.build(ContactFactory.class));
	}

}
