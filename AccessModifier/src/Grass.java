import world.Plant;

public class Grass extends Plant {
	public Grass() {
		// this won't work, grass is not in the same package as Plant event 
		// though it is subclass.
		//System.out.println(this.height);
	}
	
}
