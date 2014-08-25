package ca.tomrobinson.serialization;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import ca.tomrobinson.guicemodule.annotations.StoreFile;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactory;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

/**
 * An object retriever that starts reading from the start of the same file each time an
 * object is retrieved 
 * 
 * @author trobinson
 *
 * @param <T> type of object that can be serialized
 */
public class FileReplacingRetriever<T extends Serializable> implements ObjectRetriever<T> {

	FileBasedObjectStreamFactory _streamFactory;
	File _file;

	@Inject
	public FileReplacingRetriever(@StoreFile File file, FileBasedObjectStreamFactory streamFactory) {
		_streamFactory = streamFactory;
		_file = file;
	}
	

	@Override
	public T retrieve() {
		T result = null;
		try {
			ObjectInputStream stream = _streamFactory.getInputStream(_file);
			result = (T) stream.readObject();
			stream.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

}
