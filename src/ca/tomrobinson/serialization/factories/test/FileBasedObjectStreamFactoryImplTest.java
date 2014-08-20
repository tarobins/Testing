package ca.tomrobinson.serialization.factories.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.tomrobinson.serialization.factories.FileBasedObjectStreamFactoryImpl;

public class FileBasedObjectStreamFactoryImplTest {

	FileBasedObjectStreamFactoryImpl _streamFactory;
	File _file;
	
	@Before
	public void setUp() throws Exception {
		_streamFactory = new FileBasedObjectStreamFactoryImpl();
		_file = new File("testFile");
		if (_file.exists()) {
			_file.delete();
		}
	}

	@After
	public void tearDown() throws Exception {
		if (_file.exists()) {
			_file.delete();
		}
	}

	@Test
	public void testWriteReadInteger() {
		ObjectOutputStream outputStream = _streamFactory.getOutputStream(_file);
		
		try {
			outputStream.writeObject(new Integer(42));
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
		ObjectInputStream inputStream = _streamFactory.getInputStream(_file);
		
		try {
			assertEquals( (Integer)inputStream.readObject(), new Integer(42));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void testOverwriteInteger() {
		ObjectOutputStream outputStream = _streamFactory.getOutputStream(_file);
		
		try {
			outputStream.writeObject(new Integer(42));
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
		outputStream = _streamFactory.getOutputStream(_file);
		
		try {
			outputStream.writeObject(new Integer(56));
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
		ObjectInputStream inputStream = _streamFactory.getInputStream(_file);
		
		try {
			assertEquals( (Integer)inputStream.readObject(), new Integer(56));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
