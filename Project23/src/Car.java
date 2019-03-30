
// Now, car has all the method that machine has
public class Car extends Machine {
	// In order to override, method signature has to be sam
	// as super class.
	//@Override is optional.
	@Override
	public void start() {
		System.out.println("Car started");
	}
	
	public void wipeWindShield() {
		System.out.println("Wiping windshield");
	}
	
	public void showInfo() {
        System.out.println("Car name: " + name);
    }

}
