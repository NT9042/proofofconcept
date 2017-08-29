package drivers;

public enum SingletonEnum {
	INSTANCE;
	
	private String id;
	private String name;
	
	public void doStuff() {
		System.out.println("Hey I am singleton" + INSTANCE.hashCode());
	}
}
