
public class StarPrinter {
	public void printStar(int numberOfStars) {
		for (int i=0; i<numberOfStars; i++ ) {
			for(int j=0; j<=i; j++) 
            { 
                
                System.out.print("* "); 
            } 
            System.out.println(); 
		}
	}

}
