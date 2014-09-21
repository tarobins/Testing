package ca.tomrobinson.ui.presenter.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.contacts.SimpleContact;
import ca.tomrobinson.contacts.SimplePhoneNumber;
import ca.tomrobinson.contacts.factories.ContactFactory;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.HashMapContactStore;
import ca.tomrobinson.ui.presenter.BasicUIPresenter;
import ca.tomrobinson.ui.presenter.BasicUIViewListener;
import ca.tomrobinson.ui.view.BasicUIView;

public class BasicUIPresenterTest {

	@Mock Dialer _dialer;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	private class FakeUIView implements BasicUIView {

		BasicUIViewListener _listener;

		@Override
		public void setContactData(String[][] data) {
			
		}

		@Override
		public void setListener(BasicUIViewListener listener) {
			_listener = listener;
		}
		
		@Override
		public void setVisible(boolean visible) {
			_listener.nameEntryChanged("Tom");
			_listener.phoneEntryChanged("405");
			_listener.addContact();
			_listener.newContactSelected(0);
			_listener.dialContact();
			
			Mockito.verify(_dialer).dialNumber(new SimplePhoneNumber("405"));
		}
	}
	
	private static class FakeContactFactory implements ContactFactory {
		
		@Override
		public PhoneNumber createPhone(String phone) {
			return new SimplePhoneNumber(phone);
		}
		
		@Override
		public Contact createContact(String name, PhoneNumber phoneNumber) {
			return new SimpleContact(name, phoneNumber);
		}
	}
	

	@Test
	public void test() {
		
		ContactStore store = new HashMapContactStore();
		
		BasicUIView view = new FakeUIView();
		ContactFactory contactFactory = new FakeContactFactory();		
		
		BasicUIPresenter uiController = new BasicUIPresenter(view, store, _dialer, contactFactory);
		
		uiController.go();
	}

}
