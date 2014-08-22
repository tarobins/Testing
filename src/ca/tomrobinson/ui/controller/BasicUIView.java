package ca.tomrobinson.ui.controller;

public interface BasicUIView {

	public void setVisible(boolean visible);
	public void setContactData(String[][] data);
	public void setListener(BasicUIListener listener);
}
