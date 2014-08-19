package ca.tomrobinson.serialization.factories;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public interface FileBasedObjectStreamFactory {
	ObjectOutputStream getOutputStream(File file);
	ObjectInputStream getInputStream(File file);
		
}
