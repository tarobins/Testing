package ca.tomrobinson.serialization;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import ca.tomrobinson.guicemodule.annotations.StoreFile;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactory;

import com.google.inject.Inject;

/**
 * An object serializer that overwrites a given file each time an object is written,
 * 
 * @author trobinson
 *
 * @param <T> type of object that can be serialized
 */
public class FileReplacingSerializer<T extends Serializable> implements ObjectSerializer<T> {
	
	FileBasedObjectStreamFactory _streamFactory;
	File _file;

	/**
	 * 
	 * @param file file to which object will be written 
	 * @param streamFactory 
	 */
	@Inject
	public FileReplacingSerializer(@StoreFile File file, FileBasedObjectStreamFactory streamFactory) {
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
