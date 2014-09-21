package ca.tomrobinson.ui.presenter;

import java.util.ArrayList;
import java.util.List;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.factories.ContactFactory;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.guicemodule.annotations.DefaultStore;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.ui.view.BasicUIView;

import com.google.inject.Inject;

public class BasicUIPresenter implements UIPresenter {

	private ContactStore _contactStore; 
	private BasicUIView _view;
	private Dialer _dialer;
	private ContactFactory _contactFactory;
	private List<Contact> _contactList;
	
	private String _addName;
	private String _addPhone;
	private int _selectedRow;
	
	@Inject
	public BasicUIPresenter(BasicUIView view, @DefaultStore ContactStore contactStore, Dialer dialer, ContactFactory contactFactory) {
		_contactStore = contactStore;
		_view = view;
		_dialer = dialer;
		_contactFactory = contactFactory;
	}
	
	@Override
	public void go() {
		_view.setListener(new ViewListener());
		updateContactList();
		_view.setVisible(true);
	}
	
	private void updateContactList() {
		ArrayList<String[]> contactListAsStrings = new ArrayList<>();
		_contactList = new ArrayList<>();
		
		for (Contact c:_contactStore) {
			String[] contactAsStringArray = new String[]{c.name(), c.phone().numberAsString()};
			contactListAsStrings.add(contactAsStringArray);
			_contactList.add(c);
		}
		
		_view.setContactData(contactListAsStrings.toArray(new String[contactListAsStrings.size()][2]));
		
	}
	
	private class ViewListener implements BasicUIViewListener {

		@Override
		public void nameEntryChanged(String newName) {
			_addName = newName;
		}

		@Override
		public void phoneEntryChanged(String newPhone) {
			_addPhone = newPhone;
		}

		@Override
		public void newContactSelected(int row) {
			_selectedRow = row;
		}

		@Override
		public void addContact() {
			_contactStore.addContact(
					_contactFactory.createContact(_addName, 
							_contactFactory.createPhone(_addPhone)));
			updateContactList();
			
		}

		@Override
		public void dialContact() {
			Contact c = _contactList.get(_selectedRow);
			_dialer.dialNumber(c.phone());
		}

		@Override
		public void cancelDialog() {
			_view.setVisible(false);
			System.exit(0);
		}
		
	}
	
}
