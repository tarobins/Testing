package ca.tomrobinson.serialization.factories;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Interface for a class that generates new object input and output streams to a given file.
 * 
 * @author trobinson
 *
 */
public interface FileBasedObjectStreamFactory {
	/**
	 * Returns a new object output stream.
	 * @param file file to write the objects sent to the stream to
	 * @return the new output stream
	 */
	ObjectOutputStream getOutputStream(File file);
	
	/**
	 * Returns a new object input stream.
	 * @param file file to read objects from 
	 * @return the new input stream
	 */
	ObjectInputStream getInputStream(File file);
		
}
