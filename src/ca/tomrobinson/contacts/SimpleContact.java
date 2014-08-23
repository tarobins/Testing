package ca.tomrobinson.contacts;

import java.io.Serializable;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class SimpleContact implements Contact, Serializable {

	private static final long serialVersionUID = 1L;
	
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
	public PhoneNumber phone() {
		return _phone;
	}

}
