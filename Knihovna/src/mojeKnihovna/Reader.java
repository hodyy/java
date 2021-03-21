package mojeKnihovna;

public class Reader extends User {
	SingleScanner scanner = SingleScanner.getInstanceOfScanner();
	@Override
	public  void deleteBook(Database database) {	
		System.out.println("!!!!! NELZE PROVÉST OPERACI V ROLI USER !!!!!\n---->Stiskni ENTER<----");
		scanner.readLine();	
	}
	@Override
	public  void addBook(Database database) {	
		System.out.println("!!!!! NELZE PROVÉST OPERACI V ROLI USER !!!!!\n---->Stiskni ENTER<----");
		scanner.readLine();	
	}
	
	
}
