package ca.tomrobinson.contacts;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class SimpleContact implements Contact {

	private String _name;
	private PhoneNumber _phone;
	
	@Inject
	public SimpleContact(
			@Assisted String name, 
			@Assisted PhoneNumber phone) {
		_name = name;
		_phone = phone;
	}

	@Override
	public String name() {
		return _name;
	}

	@Override
	public PhoneNumber homePhone() {
		return _phone;
	}
	
	
}
