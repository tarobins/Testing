package ca.tomrobinson.serialization.factories;

import java.io.File;
import java.io.Serializable;

import ca.tomrobinson.serialization.FileReplacingRetriever;
import ca.tomrobinson.serialization.FileReplacingSerializer;

public interface FileReplacingSerializerFactory<T extends Serializable> {
	public FileReplacingSerializer<T> createSerializer(File file);
	public FileReplacingRetriever<T> createRetriever(File file);
}
