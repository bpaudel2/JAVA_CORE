
public class App {

	public static void main(String[] args) {
		Employee e1 = new Employee("Bikram",123456,4000.00);
		Employee e2 = new Employee("Paudel",654321,5000.00);
		e1.printEmployeeInfo();
		e1.printSocialSecurityandName();
		e2.printEmployeeInfo();
		e2.printSocialSecurityandName();
		
		StarPrinter sp1 = new StarPrinter();
		sp1.printStar(10);
		
		PrimeNumberFinder pnf = new PrimeNumberFinder();
		pnf.printPrimeNumbers(100);
	}

}
