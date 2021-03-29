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
		RecordBuilder stringBuider=new RecordBuilder();
		
		System.out.println("Zadej Název knihy");
		stringBuider.addName(scanner.readLine());		

		System.out.println("Zadej Jmeno autora");
		stringBuider.addAutor(scanner.readLine());
	
		System.out.println("Zadej datum vydání ve tvaru yyyy-mm-dd");
		stringBuider.addDate(scanner.readLine());

		System.out.println(stringBuider.getRecord());
		
		ArrayList <String> record = new ArrayList <String> ();
		record.add(stringBuider.getRecord());
		
		Parser parser =new Parser();
		parser.parseAndSaveToDatabase(record, database);
		
		database.showDatabase();
	
	}
		
	
}
