// There is no pass by reference in JAVA
// Everything is pass by value
public class App {
	public static void main(String[] args) {
		App app = new App();
        
        //===========================================
		// Primitive types are pass by value
        
        int value = 7;
        System.out.println("1. Value is: " + value);
        
        app.show(value);
        
        System.out.println("4. Value is: " + value);
        
        //===========================================
        // Non primitive types are pass by value, non primitive type stores the address
        // There is no pass by reference
        System.out.println();
        
        Person person = new Person("Bob");
        System.out.println("1. Person is: " + person);
        
        app.show(person);
        
        System.out.println("4. Person is: " + person);
	}
	
	public void show(int value) {
        System.out.println("2. Value is: " + value);
        
        value = 8;
        
        System.out.println("3. Value is: " + value);
    }
    
    public void show(Person person) {
        System.out.println("2. Person is: " + person);
        
        
        
        person = new Person("Mike");
        //This will change the value passed in.
        person.setName("Sue");
        
        System.out.println("3. Person is: " + person);
        
    }

}
