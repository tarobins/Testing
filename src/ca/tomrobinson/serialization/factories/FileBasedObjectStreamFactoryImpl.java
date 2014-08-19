package ca.tomrobinson.serialization.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileBasedObjectStreamFactoryImpl implements
		FileBasedObjectStreamFactory {

	@Override
	public ObjectOutputStream getOutputStream(File file) {
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			return new ObjectOutputStream(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ObjectInputStream getInputStream(File file) {
		try {
			FileInputStream fileIn = new FileInputStream(file);
			return new ObjectInputStream(fileIn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
