
public class Application {

	public static void main(String[] args) {
		
		int [] values; //This is value type, primitive type
		values = new int[3]; //refers to a list of integer, reference variable or reference type
		
		System.out.println(values[0]); //default value 0
		
		values[0]=10;
		values[1]=20;
		values[2]=30;
		
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
		
		for(int i=0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        
        int[] numbers = {5, 6, 7};
        
        for(int i=0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
		
		
	}

}
