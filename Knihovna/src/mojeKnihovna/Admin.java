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
		StringBuilder inputString = new StringBuilder(";;;");
		
		System.out.println("Zadej N�zev knihy");

		inputString.insert(0,scanner.readLine());
		
		System.out.println("Zadej Jmeno autora");
		inputString.insert(inputString.length()-2,scanner.readLine());

		System.out.println("Zadej datum vyd�n� ve tvaru yyyy-mm-dd");
		inputString.insert(inputString.length()-1,scanner.readLine());

		String newBook = inputString.toString();
		
		ArrayList <String> record = new ArrayList <String> ();
		record.add(newBook);
		Parser parser =new Parser();
		parser.parseAndSaveToDatabase(record, database);
		
		database.showDatabase();
	
	}
		
	
}
