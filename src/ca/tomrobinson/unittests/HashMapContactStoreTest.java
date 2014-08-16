package ca.tomrobinson.unittests;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.store.HashMapContactStore;

public class HashMapContactStoreTest {

	Contact _contactTom;
	Contact _contactBob;
	
	@Before
	public void setUp() throws Exception {
		_contactTom = Mockito.mock(Contact.class);
		Mockito.when(_contactTom.name()).thenReturn("Tom");
		
		_contactBob = Mockito.mock(Contact.class);
		Mockito.when(_contactBob.name()).thenReturn("Bob");
	}

	@Test
	public void testAddRetrieve() {
		HashMapContactStore contactStore = new  HashMapContactStore();
		
		contactStore.addContact(_contactBob);
		contactStore.addContact(_contactTom);
		
		assertSame(_contactBob, contactStore.retrieveContact("Bob"));
		assertSame(_contactTom, contactStore.retrieveContact("Tom"));
	}
	
	@Test
	public void testRemove() {
		HashMapContactStore contactStore = new  HashMapContactStore();
		
		contactStore.addContact(_contactBob);
		
		Contact retrievedBob = contactStore.retrieveContact("Bob");
		
		assertSame(_contactBob, retrievedBob);
		
		contactStore.removeContact(retrievedBob);
		
		assertNull(contactStore.retrieveContact("Bob"));
	}
}
