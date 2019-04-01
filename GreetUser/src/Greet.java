import java.util.Scanner;

public class Greet {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Please enter your name: ");
		
		//wait for the user to enter something
		String name = input.nextLine(); //You can do nextInt(), nextLine() like functions here.
		
		// Tell them what they entered
		System.out.println("Hello: "+ name);
	}
}
