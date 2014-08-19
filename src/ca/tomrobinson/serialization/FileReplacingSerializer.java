package ca.tomrobinson.serialization;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class FileReplacingSerializer<T extends Serializable> implements ObjectSerializer<T> {
	
	FileBasedObjectStreamFactory _streamFactory;
	File _file;

	@Inject
	public FileReplacingSerializer(@Named("storeFile") File file, FileBasedObjectStreamFactory streamFactory) {
		_file = file;
		_streamFactory = streamFactory;
	}
	
	@Override
	public void serialize(T object) {
		ObjectOutputStream stream = _streamFactory.getOutputStream(_file);
		try {
			stream.writeObject(object);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
