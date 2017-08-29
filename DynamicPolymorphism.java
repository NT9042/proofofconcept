package drivers;

import java.io.IOException;

import designPatterns.Bags;
import designPatterns.Purse;

/**
 * In dynamic polymorphism the actual method call is resolved dynamically
 *  that is at run time only and not at the compile time

The argument list of overriding method must be same as that of the method in parent class.
 The data types of the arguments and their sequence should be maintained as it is in the overriding method.

The Access Modifier of the overriding method (method of subclass) 
cannot be more restrictive than the overridden method of parent class.
  For e.g. if the Access Modifier of base class method is public then the
   overriding method (child class method ) cannot have private,
 protected and default Access modifier as all of the three are more restrictive than public


private, static and final methods cannot be overridden as they are local to the class.
 However static methods can be re-declared in the sub class, in this case the sub-class method would act
 differently and will have nothing to do with the same static method of parent class.
 
 Overriding method (method of child class) can throw any unchecked exceptions,
  regardless of whether the overridden method(method of parent class) throws any exception or not.
   However the overriding method 
 should not throw checked exceptions that are new or broader than the ones declared by the overridden method.
 
 
 If a class is extending an abstract class or implementing an interface then it has to
 override all the abstract methods unless the class itself is a abstract class.
 
 
 * @author nehatiwari
 *
 */
public class DynamicPolymorphism {

	public static void main(String[] args) {
		Bags bag = new Purse();
		int size = bag.holdingSize();
		System.out.println(size);
		
		System.out.println(bag.color());
		try {
			System.out.println(bag.strap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
