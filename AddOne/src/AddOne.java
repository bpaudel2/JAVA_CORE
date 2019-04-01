import java.util.Scanner;

public class AddOne {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Please enter a number: ");
		try {
			int n = input.nextInt();
			int increment = n + 1;
			System.out.println("Your number + 1 is: "+increment);

		}
		catch(Exception e) {
			System.out.println("Sorry, you did not enter integer.");
		}
		//input.close();
		
	}
}
