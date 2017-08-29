package drivers;

import java.util.function.Consumer;

import designPatterns.Connection;

public class DriverDesignPattern {
	


public static void main(String[] args) {
	Connection con = new Connection();
	Consumer<Integer> c = (Integer i)  -> con.check(i);
	System.out.println();
}
}
