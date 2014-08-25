package ca.tomrobinson.ui.presenter;

public interface BasicUIListener {
	
	public void nameEntryChanged(String newName);
	public void phoneEntryChanged(String newPhone);
	
	public void newContactSelected(int row);
	
	public void addContact();
	public void dialContact();
	
	public void cancelDialog();

}
