package ca.tomrobinson.ui.view;

import ca.tomrobinson.ui.controller.BasicUIListener;

public interface BasicUIView {

	public void setVisible(boolean visible);
	public void setContactData(String[][] data);
	public void setListener(BasicUIListener listener);
}
