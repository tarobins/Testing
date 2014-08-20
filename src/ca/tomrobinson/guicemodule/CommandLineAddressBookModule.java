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
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactory;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactoryImpl;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.HashMapContactStore;
import ca.tomrobinson.store.SerializableContactStore;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;

public class CommandLineAddressBookModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(AddressBook.class).to(AddressBookImpl.class);
		bind(Dialer.class).to(PrintScreenDialer.class);
		bind(FileBasedObjectStreamFactory.class).to(FileBasedObjectStreamFactoryImpl.class);

		bind(new TypeLiteral<ObjectRetriever<SerializableContactStore>>() {})
			.to(new TypeLiteral<FileReplacingRetriever<SerializableContactStore>>() {});
		
		bind(new TypeLiteral<ObjectSerializer<SerializableContactStore>>() {})
			.to(new TypeLiteral<FileReplacingSerializer<SerializableContactStore>>() {});
		
		bind(File.class).annotatedWith(StoreFile.class)
			.toInstance(new File("storeFile"));
		
		bind(ContactStore.class).annotatedWith(DefaultStore.class)
			.toProvider(ContactStoreProvider.class);
		
		bind(SerializableContactStore.class).annotatedWith(EmptyStore.class)
			.to(HashMapContactStore.class);
		
		
		install(new FactoryModuleBuilder()
				.implement(Contact.class, SimpleContact.class)
				.implement(PhoneNumber.class, SimplePhoneNumber.class)
				.build(ContactFactory.class));
	
	}


}
