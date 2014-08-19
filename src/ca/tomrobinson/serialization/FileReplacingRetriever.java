package ca.tomrobinson.serialization;

import java.io.File;
import java.io.Serializable;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import ca.tomrobinson.serialization.factories.FileBasedObjectSerializerFactory;

public class FileReplacingRetriever<T extends Serializable> implements ObjectRetriever<T> {

	FileBasedObjectSerializerFactory<T> _streamSerializerFactory;
	File _file;

	@Inject
	public FileReplacingRetriever(@Assisted File file, FileBasedObjectSerializerFactory<T> streamSerializerFactory) {
		_streamSerializerFactory = streamSerializerFactory;
		_file = file;
	}
	

	@Override
	public T retrieve() {
		ObjectStreamRetriever<T> retriever = _streamSerializerFactory.getRetriever(_file);
		T result = retriever.retrieve();
		retriever.close();
		return result;
	}

}
