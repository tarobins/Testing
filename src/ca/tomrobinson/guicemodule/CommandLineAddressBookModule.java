package ca.tomrobinson.guicemodule;

import java.io.File;

import ca.tomrobinson.addressbook.AddressBook;
import ca.tomrobinson.addressbook.AddressBookImpl;
import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.ContactFactory;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.contacts.SimpleContact;
import ca.tomrobinson.contacts.SimplePhoneNumber;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.dialer.PrintScreenDialer;
import ca.tomrobinson.serialization.FileReplacingRetriever;
import ca.tomrobinson.serialization.FileReplacingSerializer;
import ca.tomrobinson.serialization.ObjectRetriever;
import ca.tomrobinson.serialization.ObjectSerializer;
import ca.tomrobinson.serialization.factories.FileBasedObjectSerializerFactory;
import ca.tomrobinson.serialization.factories.FileReplacingSerializerFactory;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.HashMapContactStore;
import ca.tomrobinson.store.SerializableContactStore;
import ca.tomrobinson.store.SerializingContactStore;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class CommandLineAddressBookModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(AddressBook.class).to(AddressBookImpl.class);
		bind(Dialer.class).to(PrintScreenDialer.class);
//		bind(ContactStore.class).to(SerializingContactStore.class); //TODO: need to prepopulate
//		bind(SerializableContactStore.class).to(HashMapContactStore.class);
		bind(FileBasedObjectSerializerFactory.class).to(FileBasedObjectSerializerFactory.class);
		
		install(new FactoryModuleBuilder()
				.implement(Contact.class, SimpleContact.class)
				.implement(PhoneNumber.class, SimplePhoneNumber.class)
				.build(ContactFactory.class));
	
		install(new FactoryModuleBuilder()
				.implement(new TypeLiteral<ObjectRetriever<SerializableContactStore>>(){}, 
						new TypeLiteral<FileReplacingRetriever<SerializableContactStore>>(){})
				.implement(new TypeLiteral<ObjectSerializer<SerializableContactStore>>(){}, 
						new TypeLiteral<FileReplacingSerializer<SerializableContactStore>>(){})
				.build(FileReplacingSerializerFactory.class));
	}
//
//	@Provides
//	ContactStore providesContactStore() {
//		return new FileReplacingSerializer<>(new FileObjectSerializerFactory<>(new File("TestFile")));
//	}
	
	
//	@Provides
//	Collection<Contact> provideContactCollection() {
//		return new ArrayList<Contact>();
//	}


}
