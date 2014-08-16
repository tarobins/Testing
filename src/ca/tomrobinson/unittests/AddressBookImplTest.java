package ca.tomrobinson.unittests;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ca.tomrobinson.addressbook.AddressBookImpl;
import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.dialer.Dialer;

public class AddressBookImplTest {

	Contact _contactStub;
	PhoneNumber _phoneStub;
	Dialer _dialerStub;
	
	@Before
	public void setupMocks() {

		_phoneStub = Mockito.mock(PhoneNumber.class);
//		Mockito.when(_phoneMock.numberAsString()).thenReturn("123456");
		
		_contactStub = Mockito.mock(Contact.class);
		Mockito.when(_contactStub.name()).thenReturn("Tom");
		Mockito.when(_contactStub.homePhone()).thenReturn(_phoneStub);
		
		_dialerStub = Mockito.mock(Dialer.class);
		
	}
	
	
	@Test
	public void addAndGetHomePhone() {
		AddressBookImpl addressBook = new AddressBookImpl( _dialerStub);
		
		addressBook.add(_contactStub);
	
		PhoneNumber retrievedPhoneNumber = addressBook.getHomePhone("Tom");
		assertSame(retrievedPhoneNumber, _phoneStub);
		
//		assertEquals("123456", retrievedPhoneNumber.numberAsString());
	}
	
	@Test
	public void dialTest() {
		
		AddressBookImpl addressBook = new AddressBookImpl(_dialerStub);
		addressBook.add(_contactStub);
		
		addressBook.call("Tom");
		
		Mockito.verify(_dialerStub).dialNumber(_phoneStub);
	}

}
