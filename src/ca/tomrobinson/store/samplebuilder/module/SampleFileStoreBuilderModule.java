package ca.tomrobinson.store.samplebuilder.module;

import java.io.File;

import ca.tomrobinson.guicemodule.ContactModule;
import ca.tomrobinson.guicemodule.ContactStoreProvider;
import ca.tomrobinson.guicemodule.SerializationModule;
import ca.tomrobinson.guicemodule.annotations.DefaultStore;
import ca.tomrobinson.guicemodule.annotations.EmptyStore;
import ca.tomrobinson.guicemodule.annotations.StoreFile;
import ca.tomrobinson.serialization.FileReplacingSerializer;
import ca.tomrobinson.serialization.ObjectRetriever;
import ca.tomrobinson.serialization.ObjectSerializer;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactory;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactoryImpl;
import ca.tomrobinson.store.ContactStore;
import ca.tomrobinson.store.HashMapContactStore;
import ca.tomrobinson.store.SerializableContactStore;
import ca.tomrobinson.store.SerializingContactStore;
import ca.tomrobinson.store.samplebuilder.SampleFileStoreBuilder;
import ca.tomrobinson.store.samplebuilder.SampleFileStoreBuilderImpl;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class SampleFileStoreBuilderModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(SampleFileStoreBuilder.class).to(SampleFileStoreBuilderImpl.class);
		
		bind(File.class).annotatedWith(StoreFile.class)
			.toInstance(new File("storeFile"));
		
		bind(ContactStore.class).annotatedWith(DefaultStore.class)
		      .to(SerializingContactStore.class); //not using provider here so we don't load existing data
		bind(SerializableContactStore.class).annotatedWith(EmptyStore.class)
			.to(HashMapContactStore.class);
	
		install(new SerializationModule());
		install(new ContactModule());
	}

}
