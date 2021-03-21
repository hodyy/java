package mojeKnihovna;
import java.io.IOException;


public class Library {

	public static void main(String[] args) throws IOException {
		
		SingleScanner scanner = SingleScanner.getInstanceOfScanner();
		User user = null;
		Boolean logged=false;
		while (!logged) {
		System.out.println("Pøihlášení:\nZadej roli (admin/reader)");
		String role = scanner.readLine();
		switch(role) {
		
		case "admin":
			user=new Admin();
			logged=true;
			break;
		case "reader":
			user=new Reader();
			logged=true;
			break;

		default:
			System.out.println("!!!!! NEZNÁMÁ ROLE !!!!!\n---->Stiskni ENTER<----");
			scanner.readLine();
			break;
	                }
		}		
		
		Database database=new Database();
		
		MyFileReader reader = new MyFileReader();
		reader.readFile("C:\\projects_java\\Knihovna\\dataFile.txt", database);
		
		//Book book1= new Book("Staøec a moøe", "Ernest Hemingway", LocalDate.of(1999, 02, 15) );
				
		database.showDatabase();
		boolean end=false;
		while (!end) {
			
		System.out.println("ZVOL OPERACI:\n\n1)Pøidat knihu - stiskni (a)\n2)Odebrat knihu - stiskni (d)\n3)Pujèit knihu: stiskni (b)\n4)Vratit knihu: stiskni (r)\n5)Ukonèit program: stiskni (e)");
		
		switch(scanner.readLine()) {
		
		case "a":
			user.addBook(database);
			break;
		case "d":
			user.deleteBook(database);
			break;
			
		case "b":	
			user.borrowBook(database);
			break;
			
			
		case "r": 
			user.returnBook(database);
			break;
			
		case "e":
			end=true;
			break;
		
		
		default:
			System.out.println("!!!!! NEKOREKTNÍ VSTUP !!!!!\n---->Stiskni ENTER<----");
			scanner.readLine();
			break;
			
		}
		
		
			
			
		}
		
	scanner.closeScanner();	
		
		
	
	}
}
