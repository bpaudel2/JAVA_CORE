import java.util.ArrayList;
import java.util.HashMap;

class Animal{
	
}
public class App {
/*
 * Generic class is a class that can work with other objects.
 * You can specify what kind of object it can work with when you
 * instantiate the class. ArrayList is one of the important part of 
 * Generic. 
 * ArrayList is a member of Java collection framework. ArrayList manages 
 * an array internally. It's like having an array but you don't have to worry
 * about the size of an array and you can add and remove things.
 */
	public static void main(String[] args) {
		// Before JAVA 5
		ArrayList list = new ArrayList();
		list.add("apple");
		list.add("banana");
		list.add("orange");
		
		String fruit =(String) list.get(1); //get returns an object
		System.out.println(fruit);
		
		// Modern Style
		// You specify type of things you put in your arraylist in diamond bracket.
		
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("cat");
		strings.add("dog");
		strings.add("fly");
		
		String animal = strings.get(1); //this returns string because we specified
		System.out.println(animal);
		
		// There can be more than one type argument
		/* Hashmap is another Generic parameterize class but it takes two arguments.
		 * 
		 * 
		 */
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		
		// JAVA 7 style
		ArrayList<Animal> somelist = new ArrayList<>();//You don't have to repeat parameter.
		
	}

}
