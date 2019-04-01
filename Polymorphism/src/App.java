/* Polymorphism:
 * If you have child class of some parent class,
 * you could always use the child class anywhere you 
 * would normally use parent class
 */
public class App {

	public static void main(String[] args) {
		Plant plant1 = new Plant();
		
		// This is kind of plant, (it extends Plant)
		Tree tree = new Tree();
		
		// Polymorhism guarantees that we can use a child class
		// wherever a parent class is expected
		Plant plant2 = tree; //This is polymorphism in action
		
		// Plant2 reference a Tree, so the Tree grow() method is called.
		plant2.grow(); //Calls grow method of tree class
		
		// The type of the reference decided what methods you can actually call;
        // we need a Tree-type reference to call tree-specific methods.
        tree.shedLeaves();
        
        // ... so this won't work.
        //plant2.shedLeaves();
        
        // Another example of polymorphism.
        doGrow(tree);
    }
    
    public static void doGrow(Plant plant) {
        plant.grow();
    }

	

}
