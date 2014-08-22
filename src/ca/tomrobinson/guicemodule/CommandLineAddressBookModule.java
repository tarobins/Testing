package ca.tomrobinson.guicemodule;

import com.google.inject.AbstractModule;

public class CommandLineAddressBookModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new SerializationModule());
		install(new ModelModule());
		install(new DialerModule());
		install(new StoreModule());
		
		
		
	
	}


}
