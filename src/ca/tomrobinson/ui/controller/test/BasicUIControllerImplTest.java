package ca.tomrobinson.ui.controller.test;

import static org.junit.Assert.*;

import javax.swing.plaf.basic.BasicViewportUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.inject.assistedinject.FactoryModuleBuilder;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.ContactFactory;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.contacts.SimpleContact;
import ca.tomrobinson.contacts.SimplePhoneNumber;
import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.HashMapContactStore;
import ca.tomrobinson.ui.controller.BasicUIControllerImpl;
import ca.tomrobinson.ui.controller.BasicUIListener;
import ca.tomrobinson.ui.view.BasicUIView;

public class BasicUIControllerImplTest {

	BasicUIView _viewStub;
	Dialer _dialer = Mockito.mock(Dialer.class);
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private class UIViewStub implements BasicUIView {

		BasicUIListener _listener;
		
		@Override
		public void setVisible(boolean visible) {
			_listener.nameEntryChanged("Tom");
			_listener.phoneEntryChanged("405");
			_listener.addContact();
			_listener.newContactSelected(0);
			_listener.dialContact();
			
			Mockito.verify(_dialer).dialNumber(new SimplePhoneNumber("405"));
			
		}

		@Override
		public void setContactData(String[][] data) {
			
		}

		@Override
		public void setListener(BasicUIListener listener) {
			_listener = listener;
		}
		
	}
	

	@Test
	public void test() {
		
		ContactStore store = new HashMapContactStore();
		ContactFactory contactFactory = new ContactFactory() {
			
			@Override
			public PhoneNumber createPhone(String phone) {
				return new SimplePhoneNumber(phone);
			}
			
			@Override
			public Contact createContact(String name, PhoneNumber phoneNumber) {
				return new SimpleContact(name, phoneNumber);
			}
		};
		
		BasicUIView view = new UIViewStub();
		
		
		BasicUIControllerImpl uiController = new BasicUIControllerImpl(view, store, _dialer, contactFactory);
		
		uiController.go();
	}

}
