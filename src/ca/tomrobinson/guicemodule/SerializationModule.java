package ca.tomrobinson.guicemodule;

import java.io.File;

import ca.tomrobinson.guicemodule.annotations.StoreFile;
import ca.tomrobinson.serialization.FileReplacingRetriever;
import ca.tomrobinson.serialization.FileReplacingSerializer;
import ca.tomrobinson.serialization.ObjectRetriever;
import ca.tomrobinson.serialization.ObjectSerializer;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactory;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactoryImpl;
import ca.tomrobinson.store.SerializableContactStore;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class SerializationModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(File.class).annotatedWith(StoreFile.class)
			.toInstance(new File("storeFile"));
		
		bind(FileBasedObjectStreamFactory.class).to(FileBasedObjectStreamFactoryImpl.class);

		bind(new TypeLiteral<ObjectRetriever<SerializableContactStore>>() {})
			.to(new TypeLiteral<FileReplacingRetriever<SerializableContactStore>>() {});
		
		bind(new TypeLiteral<ObjectSerializer<SerializableContactStore>>() {})
			.to(new TypeLiteral<FileReplacingSerializer<SerializableContactStore>>() {});
		
	}

}
