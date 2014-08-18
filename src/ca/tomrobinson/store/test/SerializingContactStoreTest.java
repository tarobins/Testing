package ca.tomrobinson.store.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.serialization.ObjectSerializer;
import ca.tomrobinson.store.SerializableContactStore;
import ca.tomrobinson.store.SerializingContactStore;

public class SerializingContactStoreTest {
	
	@Mock Contact _contactTom;
	
	@Mock SerializableContactStore _mockcontactStore;
	@Mock ObjectSerializer<SerializableContactStore> _mockSerializer;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(_contactTom.name()).thenReturn("Tom");
	
		Mockito.when(_mockcontactStore.retrieveContact("Tom")).thenReturn(_contactTom);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		SerializingContactStore testStore = new SerializingContactStore(_mockcontactStore, _mockSerializer);
		
		testStore.addContact(_contactTom);
		
		Mockito.verify(_mockcontactStore).addContact(_contactTom);
		Mockito.verify(_mockSerializer).serialize(_mockcontactStore);
	}
	
	@Test 
	public void testRetrieve() {
		
		SerializingContactStore testStore = new SerializingContactStore(_mockcontactStore, _mockSerializer);
		
		Assert.assertSame(testStore.retrieveContact("Tom"), _contactTom);
	}
	
	@Test
	public void testRemove() {
		
		SerializingContactStore testStore = new SerializingContactStore(_mockcontactStore, _mockSerializer);
	
		testStore.removeContact(_contactTom);
		
		Mockito.verify(_mockcontactStore).removeContact(_contactTom);
		Mockito.verify(_mockSerializer).serialize(_mockcontactStore);
	
	}
}
