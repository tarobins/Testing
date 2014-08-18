package ca.tomrobinson.serialization;

import java.io.Serializable;

public interface ObjectRetriever <T extends Serializable> {
	public T retrieve(); 
}
