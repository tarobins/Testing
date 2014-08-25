package ca.tomrobinson.serialization;

import java.io.Serializable;

/**
 * An interface for a class that can return a serializable object of type T.
 * 
 * @author trobinson
 *
 * @param <T> type of the object that the class return
 */
public interface ObjectRetriever <T extends Serializable> {
	public T retrieve(); 
}
