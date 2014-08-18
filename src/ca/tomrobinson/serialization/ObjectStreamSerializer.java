package ca.tomrobinson.serialization;

import java.io.IOException;
import java.io.Serializable;

import com.google.inject.Inject;

public class ObjectStreamSerializer<T extends Serializable> implements ObjectSerializer<T>, ObjectRetriever<T> {


	ObjectStreamFactory _streamFactory;
	
	@Inject
	public  ObjectStreamSerializer(ObjectStreamFactory streamFactory) {
		_streamFactory = streamFactory;
	}
	
	@Override
	public void serialize(T object) {
		try {
			_streamFactory.outputStream().writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve() {
		T retrievedObject = null;
		
		try {
			retrievedObject = (T) _streamFactory.inputStream().readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		return retrievedObject;
		
	}

}
