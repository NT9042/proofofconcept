package designPatterns;

import java.io.IOException;

public class Purse extends Bags{
	@Override
	public int holdingSize() {
		// TODO Auto-generated method stub
		return 20;
	}
	
	/* base class doesn’t throw any exception but child class can throw an unchecked exception.
	 * @see designPatterns.Bags#color()
	 */
	@Override
	public String color() throws RuntimeException {
		// TODO Auto-generated method stub
		return "black";
	}
	 
	@Override
	public String strap() throws ClassCastException {
		// TODO Auto-generated method stub
		return "shortType";
	}
}
