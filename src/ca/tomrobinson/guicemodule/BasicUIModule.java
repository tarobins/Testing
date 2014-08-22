package ca.tomrobinson.guicemodule;

import ca.tomrobinson.ui.controller.BasicUIController;
import ca.tomrobinson.ui.controller.BasicUIControllerImpl;
import ca.tomrobinson.ui.view.BasicUIView;
import ca.tomrobinson.ui.view.BasicUIViewImpl;

import com.google.inject.AbstractModule;

public class BasicUIModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BasicUIController.class).to(BasicUIControllerImpl.class);
		bind(BasicUIView.class).to(BasicUIViewImpl.class);
		
	}

}
