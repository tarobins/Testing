package ca.tomrobinson.serialization.factories;

import java.io.Serializable;

import ca.tomrobinson.serialization.ObjectStreamRetriever;
import ca.tomrobinson.serialization.ObjectStreamSerializer;

public interface ObjectStreamSerializerFactory<T extends Serializable> {
	public ObjectStreamSerializer<T> getSerializer();
	public ObjectStreamRetriever<T> getRetriever();
}
