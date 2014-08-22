package ca.tomrobinson.serialization.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.tomrobinson.serialization.FileReplacingRetriever;
import ca.tomrobinson.serialization.FileReplacingSerializer;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactory;
import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactoryImpl;

public class FileReplacingSerializerAndRetrieverTest {

	private static final String FILENAME = "TestFile";
	
	File _file;
	FileBasedObjectStreamFactory _fileFactory;
	FileReplacingRetriever<Integer> _retriever;
	FileReplacingSerializer<Integer> _serializer;
	
	@Before
	public void setUp() throws Exception {
		_file = new File(FILENAME);
		
		_fileFactory = new FileBasedObjectStreamFactoryImpl();
		_retriever = new FileReplacingRetriever<>(_file, _fileFactory);
		_serializer = new FileReplacingSerializer<>(_file, _fileFactory);
	}
	
	
	@After
	public void tearDown() throws Exception {
		if (_file.exists()) {
			_file.delete();
		}
	}

	@Test
	public void testSerializeAndRetrieve() {
		Integer testInteger = new Integer(20);
		_serializer.serialize(testInteger);
		Integer retrievedInteger = _retriever.retrieve();
		
		assertEquals(testInteger, retrievedInteger);
	}
	
	@Test
	public void testSerializeReplaceAndRetrieve() {
		Integer testInteger1 = new Integer(20);
		Integer testInteger2 = new Integer(40);
		_serializer.serialize(testInteger1);
		Integer retrievedInteger = _retriever.retrieve();
		
		assertEquals(testInteger1, retrievedInteger);
	
		_serializer.serialize(testInteger2);
		retrievedInteger = _retriever.retrieve();
		
		assertEquals(testInteger2, retrievedInteger);
	}
}
