package ca.tomrobinson.serialization;

import java.io.Serializable;

import ca.tomrobinson.serialization.factories.ObjectStreamSerializerFactory;

public class FileReplacingSerializer<T extends Serializable> implements ObjectSerializer<T> {

	ObjectStreamSerializerFactory<T> _streamSerializerFactory;
	
	public FileReplacingSerializer(ObjectStreamSerializerFactory<T> streamSerializerFactory) {
		_streamSerializerFactory = streamSerializerFactory;
	}
	
	@Override
	public void serialize(T object) {
		ObjectStreamSerializer<T> serializer = _streamSerializerFactory.getSerializer();
		serializer.serialize(object);
		serializer.close();
	}

}
