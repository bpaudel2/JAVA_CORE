class Machine{
	public void start() {
		System.out.println("Machine Started");
	}
}

class Camera extends Machine{
	public void start() {
		System.out.println("Camera started");
	}
	
	public void snap() {
		System.out.println("Photo taken.");
	}
}
public class App {

	public static void main(String[] args) {
		Machine machine1 = new Machine();
        Camera camera1 = new Camera();
        
        machine1.start();
        camera1.start();
        camera1.snap();
        
        // Upcasting; we went from Camera to Machine
        Machine machine2 = camera1;
        machine2.start();
        // error: machine2.snap(); because snap is not defined for machine.
        // this happens at compile time
        
        // Downcasting
        
        
        
	}

}
