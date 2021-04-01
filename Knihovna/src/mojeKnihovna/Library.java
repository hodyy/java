package mojeKnihovna;
import java.io.IOException;



public class Library {

	public static void main(String[] args)  {
		
		
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
		
		FileReaderAndWriter readerAndWriter = new FileReaderAndWriter();
		File file = new File("dataFile.txt");	
		Parser parser=new Parser();
		
		try {
			
		parser.parseAndSaveToDatabase(readerAndWriter.readFile(file.getFilepath()), database);
		
		}
		catch (IOException e) {
			
			System.out.println("Problem pøi ètení souboru -> Konec programu ");	
			System.exit(0);
			
			}
		
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
			try {
			readerAndWriter.writeToFile(parser.parseBeforeWrite(database.getBooks()), file.getFilepath());
			}
			catch (IOException e) {
				System.out.println("Problem pøi zapisu dat!");	
				}
			end=true;
			break;
		
		
		default:
			System.out.println("!!!!! NEKOREKTNÍ VSTUP !!!!!\n---->Stiskni ENTER<----");
			scanner.readLine();
			break;
			
		}
		
		
			
			
		}
		
	scanner.closeScanner();	
	System.out.println("----------KONEC PROGRAMU--------------");	
		
	
	}


}
