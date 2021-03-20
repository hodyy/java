package mojeKnihovna;

import java.util.Scanner;

public class SingleScanner {
	private static SingleScanner singleScanner= new SingleScanner();
	Scanner scanner =new Scanner(System.in);
	private SingleScanner() {
			
	}
	
	public static SingleScanner getInstanceOfScanner() {
		
		return singleScanner;
	}
	
	public String readLine() {
		return scanner.nextLine();
		
	}
	
	public int readInt() {
		return scanner.nextInt();
		
	}
	
	
	public void closeScanner() {
		
		scanner.close();
		
	}
	
	
	
}
