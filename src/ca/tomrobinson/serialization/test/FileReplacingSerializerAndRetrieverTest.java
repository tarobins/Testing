package ca.tomrobinson.serialization.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactory;

public class FileReplacingSerializerAndRetrieverTest {

	private ObjectOutputStream _outputStream;
	private ObjectInputStream _inputStream;
	
	@Before
	public void setUp() throws Exception {
		
		PipedInputStream pipedInputStream = new PipedInputStream();
		PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
		
		_outputStream = new ObjectOutputStream(pipedOutputStream);
		_inputStream = new ObjectInputStream(pipedInputStream);
		
	}
	
	private class MockStreamFactory implements FileBasedObjectStreamFactory {

		@Override
		public ObjectOutputStream getOutputStream(File file) {
			return _outputStream;
		}

		@Override
		public ObjectInputStream getInputStream(File file) {
			return _inputStream;
		}
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSerializeAndRetrieve() {

		
		
	}

}
