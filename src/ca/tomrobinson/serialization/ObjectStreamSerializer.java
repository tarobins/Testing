package ca.tomrobinson.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.google.inject.Inject;

public class ObjectStreamSerializer<T extends Serializable> implements ObjectSerializer<T> {


	ObjectOutputStream _stream;
	
	@Inject
	public  ObjectStreamSerializer(ObjectOutputStream stream) {
		_stream = stream;
	}
	
	@Override
	public void serialize(T object) {
		try {
			_stream.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void close() {
		try {
			_stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
