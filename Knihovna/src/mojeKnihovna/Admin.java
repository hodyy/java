package mojeKnihovna;
import java.util.ArrayList;

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
		String newBook = scanner.readLine();
		System.out.println("Zadej Jmeno autora");
		newBook=newBook+";"+ scanner.readLine();
		System.out.println("Zadej datum vyd�n� ve tvaru yyyy-mm-dd");
		newBook=newBook+";"+ scanner.readLine();
		ArrayList <String> record = new ArrayList <String> ();
		record.add(newBook);
		Parser parser =new Parser();
		parser.parseAndSaveToDatabase(record, database);
		
		database.showDatabase();
	
	}
		
	
}
