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

public class FileObjectSerializerFactory<T extends Serializable> implements ObjectStreamSerializerFactory<T> {

	File _file;
	
	public FileObjectSerializerFactory(File file) {
		_file = file;
	}
	
	@Override
	public ObjectStreamSerializer<T> getSerializer() {
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(_file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			return new ObjectStreamSerializer<>(objectOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ObjectStreamRetriever<T> getRetriever() {
		
		try {
			FileInputStream fileInputStream = new FileInputStream(_file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			return new ObjectStreamRetriever<>(objectInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}return null;
	}

}
