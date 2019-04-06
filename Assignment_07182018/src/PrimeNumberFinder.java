
public class PrimeNumberFinder {

	public void printPrimeNumbers(int number) {
		// prime numbers: number that are divisible by only 1 and itself
		String primeNumbers="";
		for(int i=2;i<=number; i++) {
			int squareRoot = (int)Math.sqrt(i);
			int counter = 0;
			for (int j=2; j<=squareRoot;j++) {
				if(i%j==0) {
					counter++;
				}
			}
			if(counter==0) {
				primeNumbers= primeNumbers+" "+i;
			}
			
		}
		System.out.println("Prime Numbers under "+number+" are as follows:");
		System.out.println(primeNumbers);
	}
}
