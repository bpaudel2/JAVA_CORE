
public class App {

	public static void main(String[] args) {
		// Inefficient
		/*
		 * String are immutable in Java. Which means once you create String, 
		 * you can not change them. So, we are creating four strings here.
		 * This could potentially a memory leak.
		 *
		 */
		String info = "";
		info += "My name is Bob.";
		info += " ";
		info += "I am a builder.";
		System.out.println(info);
		
		// More efficient
		/*
		 * We can rather use String Builder for that purpose.
		 */
		StringBuilder sb = new StringBuilder("");
		
		sb.append("My name is Sue.");
		sb.append("");
		sb.append("I am a lion tamer.");
		
		System.out.println(sb.toString());
		
		// The same as above, but nicer ...
		
		StringBuilder s = new StringBuilder();
		// append method returns the reference to the object itself so that you can chain 
		// these methods.
		/*
		 * There is also a class called StringBuffer which is just a thread safe version of
		 * String Builder. 
		 */
		s.append("My name is Roger.")
		.append(" ")
		.append("I am a skydiver.");
		
		System.out.println(s.toString());
		
		// Formatting
		
		System.out.println("Here is some text.\tThat was a tab.\nThat was a newline.");
		System.out.println(" More text.");
		
		/*
		 * Formatting integer
		 * %-10d means: output an integer in a space ten character wide,
		 * padding with space and Left-aligning (%10d would right-align)
		 */
		// Left align ten character
		System.out.printf("Total cost %-10d; quantity is %d \n", 5, 120);
		
		// Demo-ing integer and string formatting control sequences
		
		for (int i=0; i<20; i++) {
			System.out.printf("%-2d: %s \n", i, "here is some text");			
		}
		
		// Formatting floating point value
		
		// Two decimal place:
		System.out.printf("Total value: %.2f \n", 5.6874);
		
		// One decimal place, Left-aligned in 6-character field:
		System.out.printf("Total value: %-6.1f \n", 343.23423);
		
		// You can also use the String.format() method if you want to retrieve
		// a formatted string.
		
		String formatted = String.format("This is a floating-point value: %.3f",5.12345);
		System.out.println(formatted);
		
		// Use double %% for outputting a % sign
		System.out.printf("Giving it %d%% is physically impossible", 100);
	
	}

}
