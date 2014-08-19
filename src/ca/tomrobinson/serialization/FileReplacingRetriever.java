package ca.tomrobinson.serialization;

import java.io.Serializable;

import ca.tomrobinson.serialization.factories.ObjectStreamSerializerFactory;

public class FileReplacingRetriever<T extends Serializable> implements ObjectRetriever<T> {

	ObjectStreamSerializerFactory<T> _streamSerializerFactory;
	
	public FileReplacingRetriever(ObjectStreamSerializerFactory<T> streamSerializerFactory) {
		_streamSerializerFactory = streamSerializerFactory;
	}
	

	@Override
	public T retrieve() {
		ObjectStreamRetriever<T> retriever = _streamSerializerFactory.getRetriever();
		T result = retriever.retrieve();
		retriever.close();
		return result;
	}

}
