import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		//Create scanner object with system.in prompt
		Scanner input = new Scanner (System.in);
		
		// Output the prompt
		System.out.println("Enter a floating point value: ");
		
		//wait for the user to enter something
		double value = input.nextDouble(); //You can do nextInt(), nextLine() like functions here.
		
		// Tell them what they entered
		System.out.println("You entered: "+ value);
	}
}
