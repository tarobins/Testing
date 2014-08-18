package ca.tomrobinson.serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface ObjectStreamFactory {
	public ObjectOutputStream outputStream();
	public ObjectInputStream inputStream();
}
