package ca.tomrobinson.store.samplebuilder;

import ca.tomrobinson.contacts.Contact;
import ca.tomrobinson.contacts.PhoneNumber;
import ca.tomrobinson.contacts.factories.ContactFactory;
import ca.tomrobinson.guicemodule.annotations.DefaultStore;
import ca.tomrobinson.store.ContactStore;

import com.google.inject.Inject;

public class SampleFileStoreBuilderImpl implements SampleFileStoreBuilder {

	
	private String samples[][] = {
			{"Tom","404044"},
			{"Bob", "323232"},
			{"Mike", "323223"}
	};
	
	private ContactStore _contactStore;
	private ContactFactory _contactFactory;
	
	@Inject
	public SampleFileStoreBuilderImpl(@DefaultStore ContactStore contactStore, ContactFactory contactFactory) {
		_contactStore = contactStore;
		_contactFactory = contactFactory;
	}
	
	/* (non-Javadoc)
	 * @see ca.tomrobinson.store.samplebuilder.SampleFileStoreBuilder#create()
	 */
	@Override
	public void create() {
		for (int i = 0; i < samples.length; i++) {
			PhoneNumber phoneNumber = _contactFactory.createPhone(samples[i][1]);
			Contact contact = _contactFactory.createContact(samples[i][0], phoneNumber);
			
			_contactStore.addContact(contact);
		}
		
	}

}
