package ca.tomrobinson.ui.view;

import ca.tomrobinson.ui.presenter.BasicUIViewListener;

public interface BasicUIView {

	public void setVisible(boolean visible);
	public void setContactData(String[][] data);
	public void setListener(BasicUIViewListener listener);
}
