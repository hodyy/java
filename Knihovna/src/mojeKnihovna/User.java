package mojeKnihovna;

public abstract class User {
	SingleScanner scanner = SingleScanner.getInstanceOfScanner();
	
	public void borrowBook(Database database){
		System.out.println("Zadej ID knihy, kterou chce� puj�it:");
		database.borrowBook(scanner.readInt());
		scanner.readLine();
		database.showDatabase();
	}
	
	public void returnBook(Database database) {
		System.out.println("Zadej ID knihy, kterou chce� vr�tit:");
		database.returnBook(scanner.readInt());
		scanner.readLine();
		database.showDatabase();
	}
	
	public void deleteBook(Database database) {
		
	}
	
	
	public void addBook(Database database) {
		
	
	}
	
}
