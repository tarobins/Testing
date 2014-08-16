package ca.tomrobinson.unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.contacts.SimpleContact;

public class SimpleContactTests {

	@Test
	public void testNameAndPhoneNumber() {
		PhoneNumber phoneMock = Mockito.mock(PhoneNumber.class);
		
		Mockito.when(phoneMock.toString()).thenReturn("123456");
		
		SimpleContact simpleContact = new SimpleContact("Tom", phoneMock);
	
		assertEquals(simpleContact.name(), "Tom");
		assertEquals(simpleContact.homePhone().toString(), "123456");
	}

}
