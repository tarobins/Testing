package ca.tomrobinson.serialization.test;

import static org.junit.Assert.assertEquals;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.tomrobinson.serialization.ObjectStreamFactory;
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
	
	private class TestObjectStreamFactory implements ObjectStreamFactory {

		@Override
		public ObjectOutputStream outputStream() {
			return _outputStream; 
		}

		@Override
		public ObjectInputStream inputStream() {
			return _inputStream;
		}
		
	}

	@Test
	public void testIntegerSerialization() {
		ObjectStreamSerializer<Integer> fileSerializer = 
				new ObjectStreamSerializer<Integer>(new TestObjectStreamFactory());
		
		fileSerializer.serialize(new Integer(42));
		
		Integer result = fileSerializer.retrieve();
		
		assertEquals(new Integer(42), result);
		
	}

}
