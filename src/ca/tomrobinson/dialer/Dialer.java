package ca.tomrobinson.dialer;

import ca.tomrobinson.contacts.PhoneNumber;

/**
 * An interface for a class capable of dialing a PhoneNumber.
 * 
 * @author trobinson
 *
 */
public interface Dialer {
	
	/**
	 * Dials the given phone number.
	 * 
	 * @param number number to dial
	 */
	public void dialNumber(PhoneNumber number);

}
