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
		RecordBuilder stringBuider=new RecordBuilder();
		
		System.out.println("Zadej N�zev knihy");
		stringBuider.addName(scanner.readLine());		

		System.out.println("Zadej Jmeno autora");
		stringBuider.addAutor(scanner.readLine());
	
		System.out.println("Zadej datum vyd�n� ve tvaru yyyy-mm-dd");
		stringBuider.addDate(scanner.readLine());

		System.out.println(stringBuider.getRecord());
		
		ArrayList <String> record = new ArrayList <String> ();
		record.add(stringBuider.getRecord());
		
		Parser parser =new Parser();
		parser.parseAndSaveToDatabase(record, database);
		
		database.showDatabase();
	
	}
		
	
}
