package ca.tomrobinson.store.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.store.HashMapContactStore;

public class HashMapContactStoreTest {

	@Mock Contact _contactTom;
	@Mock Contact _contactBob;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(_contactTom.name()).thenReturn("Tom");
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
