package ca.tomrobinson.serialization;

import java.io.File;
import java.io.Serializable;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import ca.tomrobinson.serialization.factories.FileBasedObjectSerializerFactory;

public class FileReplacingSerializer<T extends Serializable> implements ObjectSerializer<T> {

	FileBasedObjectSerializerFactory<T> _streamSerializerFactory;
	File _file;

	@Inject
	public FileReplacingSerializer(@Assisted File file, FileBasedObjectSerializerFactory<T> streamSerializerFactory) {
		_file = file;
		_streamSerializerFactory = streamSerializerFactory;
	}
	
	@Override
	public void serialize(T object) {
		ObjectStreamSerializer<T> serializer = _streamSerializerFactory.getSerializer(_file);
		serializer.serialize(object);
		serializer.close();
	}

}
