package ca.tomrobinson.serialization.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ca.tomrobinson.serialization.ObjectStreamRetriever;
import ca.tomrobinson.serialization.ObjectStreamSerializer;

public class FileBasedObjectSerializerFactoryImpl<T extends Serializable> implements FileBasedObjectSerializerFactory<T> {

	
	public FileBasedObjectSerializerFactoryImpl() {
	}
	
	@Override
	public ObjectStreamSerializer<T> getSerializer(File file) {
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			return new ObjectStreamSerializer<>(objectOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ObjectStreamRetriever<T> getRetriever(File file) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			return new ObjectStreamRetriever<>(objectInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}return null;
	}

}
