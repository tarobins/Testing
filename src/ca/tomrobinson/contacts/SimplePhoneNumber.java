package ca.tomrobinson.contacts;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class SimplePhoneNumber implements PhoneNumber {
	
	private String _phoneNumber;

	@Inject
	public SimplePhoneNumber(@Assisted String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return _phoneNumber;
	}

	@Override
	public String numberAsString() {
		return _phoneNumber;
	}

}
