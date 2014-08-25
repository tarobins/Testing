package ca.tomrobinson.dialer;

import ca.tomrobinson.contacts.PhoneNumber;

public class BigHeavyDialer implements Dialer {


	@Override
	public void dialNumber(PhoneNumber number) {
		System.out.println("Dialing " + number + " slowly.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
