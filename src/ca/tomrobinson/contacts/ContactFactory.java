package ca.tomrobinson.contacts;

public interface ContactFactory {
	public Contact createContact(String name, PhoneNumber phoneNumber);
	public PhoneNumber createPhone(String phone);
}
