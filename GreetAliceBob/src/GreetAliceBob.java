import java.util.Scanner;

public class GreetAliceBob {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Please enter your name: ");
		
		String name = input.nextLine();
		
		if (name.equalsIgnoreCase("Alice")||name.equalsIgnoreCase("Bob")) {
			System.out.println("Hello: "+ name);

		}else {
			System.out.println("Hello, Stranger");
		
		}
	}
}
