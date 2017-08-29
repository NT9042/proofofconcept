package designPatterns;

import java.io.IOException;

public class Bags implements Cloneable{
	Bags bags = new Bags();
	public int holdingSize(){
		return 100;
	}
	
	/** base class doesn’t throw any exception but child class can throw an unchecked exception.
	 * @return
	 */
	public String color() {
		return "any";
	}
	
	public String strap() throws IOException{
		return "anyType";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return this.bags;
	}
}
