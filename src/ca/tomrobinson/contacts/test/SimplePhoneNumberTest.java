package ca.tomrobinson.contacts.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.tomrobinson.contacts.SimplePhoneNumber;

public class SimplePhoneNumberTest {

	@Test
	public void testToString() {
		SimplePhoneNumber spn = new SimplePhoneNumber("1234567");
		assertEquals("1234567", spn.toString());
	}

}
