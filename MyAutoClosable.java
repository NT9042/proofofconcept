package designPatterns;

import java.io.Closeable;
import java.io.IOException;

public class MyAutoClosable implements Closeable {

	@Override
	public void close() throws IOException {
		System.out.println("Clossing it");
	}

	public void doIt() {
		
	}
}
