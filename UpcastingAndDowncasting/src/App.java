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
        Machine machine2 = camera1;//polymorphism, upcasted
        machine2.start();
        // error: machine2.snap(); because snap is not defined for machine.
        // this happens at compile time
        
        // Downcasting
        Machine machine3 = new Camera();
        Camera camera2 = (Camera)machine3;
        camera2.start();
        camera2.snap();//works because machine3 is pointing to camera object
        
        // Does not work, runtime error
        // You can not change object, you can only change reference
        Machine machine4 = new Machine();
//        Camera camera3 = (Camera)machine4; //CAN NOT do this because machine4 is referenceing machine object
//        camera3.start();
//        camera3.snap();
        
        
        
        
	}

}
