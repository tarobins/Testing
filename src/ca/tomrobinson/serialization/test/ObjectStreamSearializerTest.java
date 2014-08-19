package ca.tomrobinson.serialization.test;

import static org.junit.Assert.assertEquals;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.tomrobinson.serialization.ObjectStreamRetriever;
import ca.tomrobinson.serialization.ObjectStreamSerializer;

public class ObjectStreamSearializerTest {

	private ObjectOutputStream _outputStream;
	private ObjectInputStream _inputStream;
	
	@Before
	public void setUp() throws Exception {
		
		PipedInputStream pipedInputStream = new PipedInputStream();
		PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
		
		_outputStream = new ObjectOutputStream(pipedOutputStream);
		_inputStream = new ObjectInputStream(pipedInputStream);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testIntegerSerialization() {
		
		ObjectStreamSerializer<Integer> serializer = new ObjectStreamSerializer<>(_outputStream);
		ObjectStreamRetriever<Integer> retriever = new ObjectStreamRetriever<>(_inputStream);
	
		serializer.serialize(new Integer(42));
		
		Integer result = retriever.retrieve();
		
		assertEquals(new Integer(42), result);
		
	}

}
