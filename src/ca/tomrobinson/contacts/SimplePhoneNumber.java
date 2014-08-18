package ca.tomrobinson.contacts;

import java.io.Serializable;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class SimplePhoneNumber implements PhoneNumber, Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
