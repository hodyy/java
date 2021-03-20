package mojeKnihovna;

public class Reader extends User {
	SingleScanner scanner = SingleScanner.getInstanceOfScanner();
	
	public  void deleteBook(Database database) {	
		System.out.println("!!!!! NELZE PROVÉST OPERACI V ROLI USER !!!!!\n---->Stiskni ENTER<----");
		scanner.readLine();	
	}
	
	public  void addBook(Database database) {	
		System.out.println("!!!!! NELZE PROVÉST OPERACI V ROLI USER !!!!!\n---->Stiskni ENTER<----");
		scanner.readLine();	
	}
	
	public void borrowBook(){
		
	}
	
	public void returnBook() {
		
	}

	
}
