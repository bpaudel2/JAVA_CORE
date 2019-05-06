
public class App {
	
	/*
	 * Runtime exceptions are a kind of exceptions that you are not forced to handle. 
	 * They usually point to serious problems with your code, indicating they you need to revise it. 
	 * For example, null pointer exception and array out-of-bounds exceptions. 
	 * There are two exceptions: Checked Exception, Unchecked Exception (Runtime exception)
	 */
	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Null pointer exception ...
		String text = null;
		
		System.out.println(text.length());
		
		// Arithmetic exception .. (divide by zero)
		int value = 7/0;
		
		// You can actually handle RuntimeExceptions if you want to;
		// for example, here we handle an ArrayIndexOutOfBoundsException
		
		String[] texts = {"one","two","three"};
		
		try {
			System.out.println(texts[3]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		

	}

}
