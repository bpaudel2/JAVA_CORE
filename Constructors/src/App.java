class Machine{
	private String name;
	private int code;
	//Contructors does not return type.
	//The name of constuctor will be same as name of class
	// You can have same method name but different parameters.
	public Machine() {
		this("Arnie",0); //this calls the constructor.
		System.out.println("Contructor running");
	}
	public Machine(String name) {
		this(name,0);
		System.out.println("Second constructor is running");
	}
	public Machine(String name, int code) {
		System.out.println("Third Contructor is running.");
		this.name = name;
		this.code = code;
	}
}
public class App {

	public static void main(String[] args) {
		Machine machine1 = new Machine();
		Machine machine2 = new Machine("Bertie");
		Machine machine3 = new Machine("Chalky", 7);
	}

}
