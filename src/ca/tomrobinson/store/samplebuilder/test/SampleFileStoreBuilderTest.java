package ca.tomrobinson.store.samplebuilder.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.tomrobinson.addressbook.AddressBook;
import ca.tomrobinson.guicemodule.CommandLineAddressBookModule;
import ca.tomrobinson.store.samplebuilder.SampleFileStoreBuilder;
import ca.tomrobinson.store.samplebuilder.module.SampleFileStoreBuilderModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SampleFileStoreBuilderTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Injector builderInjector = Guice.createInjector(new SampleFileStoreBuilderModule());
		
		builderInjector.getInstance(SampleFileStoreBuilder.class).create();
		
		Injector readerInjector = Guice.createInjector(new CommandLineAddressBookModule());
		
		AddressBook book = readerInjector.getInstance(AddressBook.class);
		
		assertEquals(book.getHomePhone("Tom").numberAsString(),"404044");
		
	}

}
