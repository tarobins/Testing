package ca.tomrobinson.guicemodule;

import ca.tomrobinson.guicemodule.annotations.DefaultStore;
import ca.tomrobinson.guicemodule.annotations.EmptyStore;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.HashMapContactStore;
import ca.tomrobinson.store.SerializableContactStore;

import com.google.inject.AbstractModule;

public class StoreModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ContactStore.class).annotatedWith(DefaultStore.class)
		      .toProvider(ContactStoreProvider.class);
		bind(SerializableContactStore.class).annotatedWith(EmptyStore.class)
			.to(HashMapContactStore.class);
	}

}
