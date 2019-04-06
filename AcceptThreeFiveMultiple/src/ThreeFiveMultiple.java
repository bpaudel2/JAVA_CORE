import java.util.Scanner;

public class ThreeFiveMultiple {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.println("Please enter a number: ");
		try {
			int n = input.nextInt();
			if (n%3==0 || n%5==0) {
				System.out.println(" Your number + 1: "+ (n+1));
			}else {
				System.out.println("We only accept multiple of three or five.");
			}
		}
		catch(Exception e) {
			System.out.println("Sorry, you did not enter integer.");
		}
		
	}
}
