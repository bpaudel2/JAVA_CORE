class Frog{
	private int id;
	private String name;
	
	public Frog(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	 //We are overwriting toString method here
	public String toString() {
		return String.format("%-4d: %s",id,name);
	
		/*
		 * Efficient way to do it, would be using StringBuilder
		    StringBuilder sb = new StringBuilder();
            sb.append(id).append(": ").append(name);
        
            return sb.toString();
		 */
		
	}
	
}

// All object in Java has object as an ultimate parent.
// So, they inherit methods from it. One of the method is toString()

public class App {

	public static void main(String[] args) {
		Frog frog1 = new Frog(7,"Freddy");
		Frog frog2 = new Frog(5,"Rogger");
		
		//system.out.println to object invokes the toString() method
		/*
		 * So, you still be able to do sysout of object even if you have not
		 * defined toString() method but that will use toString method of Object
		 * class. And prints out name of class and some hascode. 
		 */
		System.out.println(frog1);
		System.out.println(frog2);
		
	}

}
