package mojeKnihovna;

import java.time.LocalDate;

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
		System.out.println("Zadej ID knihy, kter� se m� odebrat:");	
		database.deleteBookFromDatabase(scanner.readInt());
		database.showDatabase();
		// NEVIM PRO� ALE MUS� TU B�T TOTO JINAK BERE VSTUP PRO DAL�� OPERACI. PRO�?????
		scanner.readLine();
	}
	
	
	public void addBook(Database database) {
		System.out.println("Zadej N�zev knihy");
		String name = scanner.readLine();
		System.out.println("Zadej Jmeno autora");
		String autor = scanner.readLine();
		System.out.println("Zadej datum vyd�n� ve tvaru yyyy-mm-dd");
		String date = scanner.readLine();
		
		Book book=new Book(name, autor,LocalDate.parse(date));
		database.addBookToDatabase(book);
		
		database.showDatabase();
	
	}
	
}
