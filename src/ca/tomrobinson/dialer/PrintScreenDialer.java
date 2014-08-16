package ca.tomrobinson.dialer;

import ca.tomrobinson.contacts.PhoneNumber;

public class PrintScreenDialer implements Dialer {

	public PrintScreenDialer() {
	}

	@Override
	public void dialNumber(PhoneNumber number) {
		System.out.println("Dialing number: " + number.numberAsString());
	}

}
