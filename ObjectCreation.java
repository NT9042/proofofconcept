package drivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import designPatterns.Employee;
import designPatterns.Human;

/**
 * @author nehatiwari
 *
 */
public class ObjectCreation {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		 // By using new keyword
        Employee emp1 = new Employee();
        emp1.setName("Naresh");
        System.out.println(emp1 + ", hashcode : " + emp1.hashCode());

        Employee emp2 = (Employee) Class.forName("designPatterns.Employee").newInstance();
        //emp2 = Employee.class.newInstance();
        emp2.setName("Rishi");
        System.out.println(emp2 + ", hashcode : " + emp2.hashCode());

        Constructor<Employee> conts = Employee.class.getConstructor(null);
        Employee emp3 = conts.newInstance(null);
        emp3.setName("Yogesh");
        System.out.println(emp3 + ", hashcode : " + emp3.hashCode());
        Thread t;
        Employee emp4 = (Employee)emp2.clone();
        emp4.setName("Atul");
        System.out.println(emp4 + ", hashcode : " + emp4.hashCode());
        
        // By using Deserialization
        // Serialization
        emp4.setHuman(new Human("Ramesh chchaha"));
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.obj"));
        out.writeObject(emp4);
        out.close();
        
        //Deserialization
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.obj"));
        Employee emp5 = (Employee) in.readObject();
        emp5.setHuman(new Human("Hanuman"));
        System.out.println(emp5.getHuman().getNameOfHuman());
        in.close();
        
        
        emp5.setName("Ritesh");
        System.out.println(emp5 + ", hashcode : " + emp5.hashCode());
        
	}

}
