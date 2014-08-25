package ca.tomrobinson.serialization;

import java.io.Serializable;

/**
 * An interface for a class that can serialize a serializable object of type T.
 * 
 * @author trobinson
 *
 * @param <T> the type that can be serialized
 */
public interface ObjectSerializer <T extends Serializable> {
	public void serialize(T object);
}
