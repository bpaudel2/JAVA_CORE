
public class Machine {
	// protected variable can be accessed by subclass
	// private variable won't be able to access only from same class
	// public can be accessed by anywhere in package
	// Never override variable 
	protected String name = "Machine Type 1";
	
	public void start() {
		System.out.println("Machine started.");
	}
	
	public void stop() {
		System.out.println("Machine stopped.");
	}

}
