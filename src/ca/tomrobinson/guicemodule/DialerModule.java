package ca.tomrobinson.guicemodule;

import ca.tomrobinson.dialer.Dialer;
import ca.tomrobinson.dialer.PrintScreenDialer;

import com.google.inject.AbstractModule;

public class DialerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Dialer.class).to(PrintScreenDialer.class);
	}

}
