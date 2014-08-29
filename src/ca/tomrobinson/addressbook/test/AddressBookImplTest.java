package ca.tomrobinson.addressbook.test;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ca.tomrobinson.addressbook.AddressBookImpl;
import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.store.ContactStore;

public class AddressBookImplTest {

	@Mock Contact _contactStub;
	@Mock PhoneNumber _phoneStub;
	@Mock Dialer _dialerStub;
	@Mock ContactStore _storeStub;
	
	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
//		Mockito.when(_phoneStub.numberAsString()).thenReturn("123456");
		
		Mockito.when(_contactStub.name()).thenReturn("Tom");
		Mockito.when(_contactStub.phone()).thenReturn(_phoneStub);
		
		Mockito.when(_storeStub.retrieveContact("Tom")).thenReturn(_contactStub);
	}
	
	
	@Test
	public void addAndGetHomePhone() {
		AddressBookImpl addressBook = new AddressBookImpl( _dialerStub,_storeStub);
		
		addressBook.add(_contactStub);
	
		PhoneNumber retrievedPhoneNumber = addressBook.getHomePhone("Tom");
		assertSame(retrievedPhoneNumber, _phoneStub);
		
//		assertEquals("123456", retrievedPhoneNumber.numberAsString());
	}
	
	@Test
	public void dialTest() {
		AddressBookImpl addressBook = new AddressBookImpl(_dialerStub,_storeStub);
		addressBook.add(_contactStub);
		
		addressBook.call("Tom");
		
		Mockito.verify(_dialerStub).dialNumber(_phoneStub);
	}

}
