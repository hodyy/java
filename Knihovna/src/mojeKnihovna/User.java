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
		System.out.println("Zadej ID knihy, která se má odebrat:");	
		database.deleteBookFromDatabase(scanner.readInt());
		database.showDatabase();
		// NEVIM PROÈ ALE MUSÍ TU BÝT TOTO JINAK BERE VSTUP PRO DALŠÍ OPERACI. PROÈ?????
		scanner.readLine();
	}
	
	
	public void addBook(Database database) {
		System.out.println("Zadej Název knihy");
		String name = scanner.readLine();
		System.out.println("Zadej Jmeno autora");
		String autor = scanner.readLine();
		System.out.println("Zadej datum vydání ve tvaru yyyy-mm-dd");
		String date = scanner.readLine();
		
		Book book=new Book(name, autor,LocalDate.parse(date));
		database.addBookToDatabase(book);
		
		database.showDatabase();
	
	}
	
}
