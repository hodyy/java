package mojeKnihovna;

public abstract class User {
	SingleScanner scanner = SingleScanner.getInstanceOfScanner();
	
	public void borrowBook(Database database) {
		System.out.println("Zadej ID knihy, kterou chce� puj�it:");
		 
		switch(database.borrowBook(scanner.readInt())) {
		case OK:
			System.out.println("KNIHA PUJ�ENA");
			break;
		case NOT_EXIST:
			System.out.println("TATO KNIHA NEN� V KNIHOVN�");
			break;
		case BORROWED:
			System.out.println("KNIHA JE JI� PUJ�ENA");
			break;
		case ERROR:
			System.out.println("Chyba p�i praci s DB");
			break;
		case RETURNED:
			break;
			             
		}		
		scanner.readLine();
	}
	
	public void returnBook(Database database) {
		System.out.println("Zadej ID knihy, kterou chce� vr�tit:");
		
		switch(database.returnBook(scanner.readInt())) {
		case OK:
			System.out.println("KNIHA VRACENA");
			break;
		case NOT_EXIST:
			System.out.println("TATO KNIHA NEN� V KNIHOVN�");
			break;
		case RETURNED:
			System.out.println("KNIHA JE JI� VR�CENA");
			break;
		case ERROR:
			System.out.println("Chyba p�i praci s DB");
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
	
