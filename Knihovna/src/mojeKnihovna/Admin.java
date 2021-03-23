package mojeKnihovna;
import java.util.ArrayList;

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
		String newBook = scanner.readLine();
		System.out.println("Zadej Jmeno autora");
		newBook=newBook+";"+ scanner.readLine();
		System.out.println("Zadej datum vydání ve tvaru yyyy-mm-dd");
		newBook=newBook+";"+ scanner.readLine();
		ArrayList <String> record = new ArrayList <String> ();
		record.add(newBook);
		Parser parser =new Parser();
		parser.parseAndSaveToDatabase(record, database);
		
		database.showDatabase();
	
	}
		
	
}
