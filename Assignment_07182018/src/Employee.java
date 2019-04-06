
public class Employee {
	private String name;
	private int ssn;
	private double salary;
	
	public Employee(String name, int ssn, double salary) {
		this.name = name;
		this.ssn = ssn;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", ssn=" + ssn + ", salary=" + salary + "]";
	}

	public void printEmployeeInfo() {
		String employeeInfo = this.toString();
		System.out.println(employeeInfo);
	}

	public void printSocialSecurityandName() {
		System.out.println("Name: "+this.name);
		System.out.println("SSN: "+this.ssn);
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
