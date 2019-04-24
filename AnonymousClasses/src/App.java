class Machine{
	public void start() {
		System.out.println("Starting machine ...");
	}
}

interface Plant{
	public void grow();//No implementation here
}
public class App {
	public static void main(String[] args) {
		/*
		 * Anonymous classes in Java are a handy way of creating 
		 * "one off" objects using un-named classes that you create
		 * on the fly.
		 */
		Machine machine1 = new Machine(){
			//You can override methods here
			//This will be a child class of machine
			@Override
			public void start() {
				System.out.println("Camera Snapping...");
			}
		};
		machine1.start();
		
		// This is equivalent to creating a class that "implements"
        // the Plant interface
		// Plant plant1 = new Plant(); won't work because you can not
		// create object off of interface.
        Plant plant1 = new Plant() {
            @Override
            public void grow() {
                System.out.println("Plant growing");
                
            }
        };
        
        plant1.grow();
        
        // This often used in Listener Event Pattern
	}

}
