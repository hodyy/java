package mojeKnihovna;

import java.time.LocalDate;

public class Admin extends User {
	
	
	public Admin() {}
	
	@Override
	public void deleteBook(Database database) {
		System.out.println("Zadej ID knihy, která se má odebrat:");	
		database.deleteBookFromDatabase(scanner.readInt());
		database.showDatabase();
		// NEVIM PROÈ ALE MUSÍ TU BÝT TOTO JINAK BERE VSTUP PRO DALŠÍ OPERACI. PROÈ?????
		scanner.readLine();
	}
	
	@Override
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
