package ca.tomrobinson.guicemodule;

import java.io.File;

import ca.tomrobinson.guicemodule.annotations.StoreFile;

import com.google.inject.AbstractModule;

public class CommandLineAddressBookModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new SerializationModule());
		bind(File.class).annotatedWith(StoreFile.class)
			.toInstance(new File("storeFile"));
		
		install(new AddressBookModule());
		install(new DialerModule());
		install(new StoreModule());
		install(new ContactModule());
	}


}
