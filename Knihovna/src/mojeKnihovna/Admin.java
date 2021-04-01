package mojeKnihovna;
public class Admin extends User {
	
	
	public Admin() {}
	
	@Override
	public void deleteBook(Database database) {
		System.out.println("Zadej ID knihy, která se má odebrat:");	
		database.deleteBookFromDatabase(scanner.readInt());
		database.showDatabase();	
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
		
		while(!stringBuider.addDate(scanner.readLine())) {
			System.out.println("!!!!! ŠPATNĚ ZADANÝ FORMAT DATUMU  !!!!!\n---->Stiskni ENTER<----");
			scanner.readLine();
			System.out.println("Zadej datum vydání ve tvaru yyyy-mm-dd");
			
		}
		
		Parser parser =new Parser();
		parser.parseAndSaveToDatabase(stringBuider.getFullRecord(), database);
		
		database.showDatabase();
	}
		
	
}
