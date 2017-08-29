package drivers;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import designPatterns.MyAutoClosable;

public class TryWithResourceConstruct {

	public static void main(String[] args) {
		readWithTryWith();
		
	}

	public static void readWithoutTryWith() {
		InputStream input = null;
		try{
			input = new FileInputStream("employee.obj");
			int data = input.read();
			while(data != -1){
				System.out.println((char) data);
				data = input.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(input != null)
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * This is the try-with-resources construct. The FileInputStream variable is
	 * declared inside the parentheses after the try keyword. Additionally, a
	 * FileInputStream is instantiated and assigned to the variable. When the
	 * try block finishes the FileInputStream will be closed automatically. This
	 * is possible because FileInputStream implements the Java interface
	 * java.lang.AutoCloseable. All classes implementing this interface can be
	 * used inside the try-with-resources construct. If an exception is thrown
	 * both from inside the try-with-resources block, and when the
	 * FileInputStream is closed (when close() is called), the exception thrown
	 * inside the try block is thrown to the outside world. The exception thrown
	 * when the FileInputStream was closed is suppressed. This is opposite of
	 * what happens in the example first in this text, using the old style
	 * exception handling (closing the resources in the finally block).
	 */
	public static void readWithTryWith() {
		try(FileInputStream input = new FileInputStream("employee.obj")) {
			int data = input.read();
			while(data != -1) {
				System.out.println((char) data);
				data = input.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mulitpleResources() {
		try(FileInputStream input = new FileInputStream("employee.obj");
			BufferedInputStream buff = new BufferedInputStream(input)) {
			int data = buff.read();
			while(data != -1) {
				System.out.println((char) data);
				data = input.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Any class that implements this interface can be used with the try-with-resources construct. 
	 * Here is a simple example implementation:
	 */
	public static void customeResources() {
		try(MyAutoClosable myAutoClosable = new MyAutoClosable()) {
			myAutoClosable.doIt();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
}
