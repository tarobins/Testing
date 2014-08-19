package ca.tomrobinson.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import com.google.inject.Inject;

public class ObjectStreamRetriever<T extends Serializable> implements ObjectRetriever<T> {


	ObjectInputStream _stream;
	
	@Inject
	public  ObjectStreamRetriever(ObjectInputStream stream) {
		_stream = stream;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve() {
		T retrievedObject = null;
		
		try {
			retrievedObject = (T) _stream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		return retrievedObject;
		
	}
	
	public void close() {
		try {
			_stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
