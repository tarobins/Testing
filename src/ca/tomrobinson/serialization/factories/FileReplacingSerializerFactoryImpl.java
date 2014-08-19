package ca.tomrobinson.serialization.factories;

import java.io.File;
import java.io.Serializable;

import com.google.inject.Inject;

import ca.tomrobinson.serialization.FileReplacingRetriever;
import ca.tomrobinson.serialization.FileReplacingSerializer;

public class FileReplacingSerializerFactoryImpl<T extends Serializable> implements
		FileReplacingSerializerFactory<T> {

	private FileBasedObjectStreamFactory _streamFactory;
	private File _file;

	@Inject
	public FileReplacingSerializerFactoryImpl(File file, FileBasedObjectStreamFactory streamFactory) {
		_streamFactory = streamFactory;
	}
	
	@Override
	public FileReplacingSerializer<T> createSerializer() {
		return new FileReplacingSerializer<>(_file, _streamFactory);
	}

	@Override
	public FileReplacingRetriever<T> createRetriever() {
		return new FileReplacingRetriever<>(_file, _streamFactory);
	}

}
