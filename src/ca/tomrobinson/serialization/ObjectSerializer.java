package ca.tomrobinson.serialization;

import java.io.Serializable;

public interface ObjectSerializer <T extends Serializable> {
	public void serialize(T object);
}
