package demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// You can also catch an expression
		File file = new File ("test.txt");
		try {
		FileReader fr = new FileReader(file);
		}catch(FileNotFoundException e){
			//e.printStackTrace();
			System.out.println("File Not Found "+file.toString());
		}
		
		System.out.println("FINISHED !!!");
	}

}
