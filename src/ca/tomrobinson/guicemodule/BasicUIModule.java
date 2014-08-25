package ca.tomrobinson.guicemodule;

import ca.tomrobinson.ui.presenter.BasicUIPresenter;
import ca.tomrobinson.ui.presenter.UIPresenter;
import ca.tomrobinson.ui.view.BasicUIView;
import ca.tomrobinson.ui.view.BasicUIViewImpl;

import com.google.inject.AbstractModule;

public class BasicUIModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(UIPresenter.class).to(BasicUIPresenter.class);
		bind(BasicUIView.class).to(BasicUIViewImpl.class);
		
	}

}
