package mojeKnihovna;

import java.time.LocalDate;

public abstract class User {
	SingleScanner scanner = SingleScanner.getInstanceOfScanner();
	
	public void borrowBook(Database database){
		System.out.println("Zadej ID knihy, kterou chceš pujèit:");
		database.borrowBook(scanner.readInt());
		scanner.readLine();
		database.showDatabase();
	}
	
	public void returnBook(Database database) {
		System.out.println("Zadej ID knihy, kterou chceš vrátit:");
		database.returnBook(scanner.readInt());
		scanner.readLine();
		database.showDatabase();
	}
	
	public void deleteBook(Database database) {
		
	}
	
	
	public void addBook(Database database) {
		
	
	}
	
}
