
public class App {
	/*
	 * Abstract classes allow you to define the parent class of a new hierarchy without
	 * having to worry about the user actually instantiating the parent. For instance you 
	 * could create an Animal class just to act as the basis for "Dog", "Cat", "Sheep" and 
	 * so on, even defining some functionality in "Animal", but at the same time preventing 
	 * the user of your hierarchy from trying to create an "Animal" object
	 * When to use Interface and Abstract. Classes can extends one class but can implements many interfaces
	 * In Abstract class, you can have default functionality. 
	 */
	public static void main (String[] args) {
		Camera cam1 = new Camera();
		cam1.setId(5);
		
		Car car1 = new Car();
		car1.setId(4);
		
		car1.run();
		// You can not instantiate Abstract class
		//Machine machine1 = new Machine();
	}

}
