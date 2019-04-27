
public enum Animal {
	
	CAT("Fergus"), DOG("Fido"), MOUSE("Jerry");
    
	private String name;
    
	// Giving enum type constructor and method
	// You can not make constructor public and can not use
	// new but we can still pass parameter and object will 
	// have those properties.
	Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "This animal is called "+name;
	}
}
