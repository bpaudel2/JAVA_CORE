import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) throws FileNotFoundException{
		// backslash is escape character in string. So, windows file path has proble
		// You can also use forward slash on windows
		String filename ="C:/Users/Bikram/projects/JAVA_CORE/ReadingFiles/src/files/example.txt";
		File testFile = new File(filename);
		
		Scanner in = new Scanner(testFile);//throwing exception in method level rather than using try catch
		
		//This wil throw an input mismatch because it is file does not have an int. 
		//int value = in.nextInt();
		//System.out.println("Read value: "+value);
		
		in.nextLine();//read the first line
		
		int count = 2;
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			
			System.out.println(count +": "+line);
			count++;
		}
		
		in.close();
	}
	
}
