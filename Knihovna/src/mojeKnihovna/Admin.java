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
		StringBuilder inputString = new StringBuilder(scanner.readLine());
		inputString.append(";");	
		System.out.println("Zadej Jmeno autora");
		inputString.append(scanner.readLine());
		inputString.append(";");

		System.out.println("Zadej datum vyd�n� ve tvaru yyyy-mm-dd");
		inputString.append(scanner.readLine());
		inputString.append(";");
		String newBook = inputString.toString();
		
		ArrayList <String> record = new ArrayList <String> ();
		record.add(newBook);
		
		Parser parser =new Parser();
		parser.parseAndSaveToDatabase(record, database);
		
		database.showDatabase();
	
	}
		
	
}
