package drivers;

import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import designPatterns.Bags;

public class SimpleThreadPool {
	 public static void main(String[] args) {
		 
		 CLtst bag = new CLtst();
		 CLtst bag1 = (CLtst) bag.clone();
		 SingletonEnum.INSTANCE.doStuff();
		 
	 }
	 
	 public static int give() {
		 try {
			 throw new Exception();
		 }catch(Exception e) {
			 return 1;
		 }finally{
			 return 3;
		 }
	 }
	 
	 
}
