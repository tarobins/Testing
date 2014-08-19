package ca.tomrobinson.guicemodule;

import java.io.File;

import ca.tomrobinson.serialization.ObjectRetriever;
import ca.tomrobinson.serialization.ObjectSerializer;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.SerializableContactStore;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class ContactStoreProvider implements Provider<ContactStore> {

	private ContactStore _emptyContactStore;
	private ObjectSerializer<SerializableContactStore> _serializer;
	private ObjectRetriever<SerializableContactStore> _retriever;
	private File _file;

	@Inject
	public ContactStoreProvider(@Named("emptyStore") ContactStore emptyContactStore,
			ObjectSerializer<SerializableContactStore> serializer,
			ObjectRetriever<SerializableContactStore> retriever,
			@Named("storeFile") File file) {
		_emptyContactStore = emptyContactStore;
		_serializer = serializer;
		_retriever = retriever;
		_file = file;
	}
	
	@Override
	public ContactStore get() {
	
		if (_file.exists()) {
			SerializableContactStore possibleStore = _retriever.retrieve();
		
			if (possibleStore != null) {
				return possibleStore;
			}
		}
		
		return _emptyContactStore;
		
	}

}
