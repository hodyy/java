package mojeKnihovna;

public abstract class User {
	SingleScanner scanner = SingleScanner.getInstanceOfScanner();
	
	public void borrowBook(Database database) {
		System.out.println("Zadej ID knihy, kterou chceš pujèit:");
		 
		switch(database.borrowBook(scanner.readInt())) {
		case OK:
			System.out.println("KNIHA PUJÈENA");
			break;
		case NOT_EXIST:
			System.out.println("TATO KNIHA NENÍ V KNIHOVNÌ");
			break;
		case BORROWED:
			System.out.println("KNIHA JE JIŽ PUJÈENA");
			break;
		case ERROR:
			System.out.println("Chyba pøi praci s DB");
			break;
		case RETURNED:
			break;
			             
		}		
		scanner.readLine();
	}
	
	public void returnBook(Database database) {
		System.out.println("Zadej ID knihy, kterou chceš vrátit:");
		
		switch(database.returnBook(scanner.readInt())) {
		case OK:
			System.out.println("KNIHA VRACENA");
			break;
		case NOT_EXIST:
			System.out.println("TATO KNIHA NENÍ V KNIHOVNÌ");
			break;
		case RETURNED:
			System.out.println("KNIHA JE JIŽ VRÁCENA");
			break;
		case ERROR:
			System.out.println("Chyba pøi praci s DB");
			break;
		case BORROWED:
			break;
			             
		}		 
		scanner.readLine();
	}
	
	public void deleteBook(Database database) {
		
	}
	
	
	public void addBook(Database database) {
		
	
	}
	public void addAuthor(Database database){
		
		
	}
	
}
