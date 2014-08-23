package ca.tomrobinson.main;

import javax.swing.SwingUtilities;

import ca.tomrobinson.guicemodule.BasicGUIAddressBookModule;
import ca.tomrobinson.ui.controller.BasicUIController;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GUIAddressBook {

	public static void createGUI() {
		Injector injector = Guice.createInjector(new BasicGUIAddressBookModule());
		
		BasicUIController controller = injector.getInstance(BasicUIController.class);
		
		controller.go();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createGUI();
			}
		});

	}

}
