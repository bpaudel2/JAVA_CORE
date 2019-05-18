class Temp implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Closing");
		
	}
	
}



public class App {
	public static void main (String[] args) {
		Temp temp = new Temp();
		try {
			temp.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// Try with resources; close is automatically called.
		try(Temp temp1 = new Temp()){
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
