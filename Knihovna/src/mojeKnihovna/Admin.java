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
		StringBuilder inputString = new StringBuilder(scanner.readLine());
		inputString.append(";");	
		System.out.println("Zadej Jmeno autora");
		inputString.append(scanner.readLine());
		inputString.append(";");

		System.out.println("Zadej datum vydání ve tvaru yyyy-mm-dd");
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
