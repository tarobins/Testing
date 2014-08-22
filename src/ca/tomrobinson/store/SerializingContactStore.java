package ca.tomrobinson.store;

import java.util.Iterator;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.guicemodule.annotations.DefaultStore;
import ca.tomrobinson.guicemodule.annotations.EmptyStore;
import ca.tomrobinson.serialization.ObjectSerializer;

import com.google.inject.Inject;

public class SerializingContactStore implements ContactStore {

	SerializableContactStore _contactStore;
	ObjectSerializer<SerializableContactStore> _serializer;

	@Inject
	public SerializingContactStore(@EmptyStore SerializableContactStore contactStore, ObjectSerializer<SerializableContactStore> serializer) {
		_serializer = serializer;
		_contactStore = contactStore;
	}

	@Override
	public void addContact(Contact contact) {
		_contactStore.addContact(contact);
		_serializer.serialize(_contactStore);
	}

	@Override
	public void removeContact(Contact contact) {
		_contactStore.removeContact(contact);
		_serializer.serialize(_contactStore);
	}

	@Override
	public Contact retrieveContact(String name) {
		return _contactStore.retrieveContact(name);
	}

	@Override
	public Iterator<Contact> iterator() {
		return _contactStore.iterator();
	}
	

}
