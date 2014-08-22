package ca.tomrobinson.guicemodule;

import java.io.File;

import ca.tomrobinson.guicemodule.annotations.EmptyStore;
import ca.tomrobinson.guicemodule.annotations.StoreFile;
import ca.tomrobinson.serialization.ObjectRetriever;
import ca.tomrobinson.serialization.ObjectSerializer;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.SerializableContactStore;
import ca.tomrobinson.store.SerializingContactStore;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ContactStoreProvider implements Provider<ContactStore> {

	private SerializableContactStore _emptyContactStore;
	private ObjectSerializer<SerializableContactStore> _serializer;
	private ObjectRetriever<SerializableContactStore> _retriever;
	private File _file;

	@Inject
	public ContactStoreProvider(@EmptyStore SerializableContactStore emptyContactStore,
			ObjectSerializer<SerializableContactStore> serializer,
			ObjectRetriever<SerializableContactStore> retriever,
			@StoreFile File file) {
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
				return new SerializingContactStore(possibleStore, _serializer);
			}
		}
		
		return new SerializingContactStore(_emptyContactStore, _serializer);
		
	}

}
