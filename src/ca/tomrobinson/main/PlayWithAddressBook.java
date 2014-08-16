package ca.tomrobinson.main;

import ca.tomrobinson.addressbook.AddressBook;
import ca.tomrobinson.contacts.ContactFactory;
import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.guicemodule.CommandLineAddressBookModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class PlayWithAddressBook {

	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new CommandLineAddressBookModule());
		
		AddressBook book = injector.getInstance(AddressBook.class);
		
		ContactFactory addressBookFactory = injector.getInstance(ContactFactory.class);
		
		PhoneNumber n = addressBookFactory.createPhone("405");
		Contact c = addressBookFactory.createContact("Tom", n);
		
		book.add(c);
		
		PhoneNumber p = book.getHomePhone("Tom");
		
		System.out.println(p.numberAsString());
		book.call("Tom");

	}

}
