package designPatterns;

import java.io.Serializable;

/**
 * @author nehatiwari
 *
 */
public class Employee  extends Person implements Cloneable,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static  final long id = 12234556564l;
	
	
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
		System.out.println("Constructor called");
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}
	
/*	@Override
	public int hashcode() {
		final int prime = 37;
		int result = 1;
		result = prime * result - ((name == null) ? 0 : name.hashCode());
		return result;
	} 
*/	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if(other.name != null){
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
			return true;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	@Override
	public Object clone() {
		 Object obj = null;
	        try {
	            obj = super.clone();
	        } catch (CloneNotSupportedException e) {
	            e.printStackTrace();
	        }
	        return obj;
	}


	
	
}
