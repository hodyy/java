package mojeKnihovna;

import java.time.LocalDate;

public class Admin extends User {
	
	
	public Admin() {}
	
	@Override
	public void deleteBook(Database database) {
		System.out.println("Zadej ID knihy, kter� se m� odebrat:");	
		database.deleteBookFromDatabase(scanner.readInt());
		database.showDatabase();
		// NEVIM PRO� ALE MUS� TU B�T TOTO JINAK BERE VSTUP PRO DAL�� OPERACI. PRO�?????
		scanner.readLine();
	}
	
	@Override
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
