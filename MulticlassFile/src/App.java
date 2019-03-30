class Person{
	// Instance variables (data or state)
	String name;
	int age;
	
	//Classes can contain
	//1. Data
	//2. Methods
}



public class App {
	//filename should match with your public class.
	//you can have only one public class in a file and as many other classes
	public static void main(String[] args) {
		// Create a Person object using Person class
		Person person1 = new Person();
		person1.name = "Joe Bloggs";
		person1.age = 37;
		
		// Create a second Person object
		Person person2 = new Person();
		person2.name = "Sarah Smith";
		person2.age = 20;
		
		System.out.println(person1.name);
		
		
	}

}
