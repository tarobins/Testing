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
	
	@Override
	public boolean equals(Object other) {
		if (other != null && other instanceof SimplePhoneNumber) {
			if (this._phoneNumber != null) {
				if (_phoneNumber.equals(((SimplePhoneNumber) other)._phoneNumber)) {
					return true;
				}
			} else {
				return ((SimplePhoneNumber)other)._phoneNumber == null;
			}
		}
		return false;
	}

}
