package ca.tomrobinson.serialization.factories;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import ca.tomrobinson.serialization.ObjectStreamRetriever;
import ca.tomrobinson.serialization.ObjectStreamSerializer;

public interface FileBasedObjectSerializerFactory<T extends Serializable> {
	public ObjectStreamSerializer<T> getSerializer(File file);
	public ObjectStreamRetriever<T> getRetriever(File file);
}
