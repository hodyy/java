package mojeKnihovna;

import java.sql.SQLException;



public class Library {

	public static void main(String[] args)  {
		
		
		SingleScanner scanner = SingleScanner.getInstanceOfScanner();
		User user = null;
		Boolean logged=false;
		while (!logged) {
		System.out.println("P�ihl�en�:\nZadej roli (admin/reader)");
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
			System.out.println("!!!!! NEZN�M� ROLE !!!!!\n---->Stiskni ENTER<----");
			scanner.readLine();
			break;
	                }
		}		
		
		Database database =new Database("root");
		Display display=new Display();
		
		boolean end=false;
		while (!end) {
	
			try {
				display.showAllbooks(database.selectAllBooksFromDB());		
			} catch (SQLException e) {		
				System.out.println("chyba p�i vyb�ru dat z DB");	
			}
			
		System.out.println("ZVOL OPERACI:\n\n1)P�idat knihu - stiskni (a)\n2)Odebrat knihu - stiskni (d)\n3)Puj�it knihu: stiskni (b)\n4)Vratit knihu: stiskni (r)\n5)Ukon�it program: stiskni (e)");
		
		switch(scanner.readInt()) {
		
		case 1:
			scanner.readLine();
			user.addBook(database);
			break;
			
		case 2:
			user.deleteBook(database); 
			break;	
			
		case 3:	
			
			user.borrowBook(database);

			break;
		
			
		case 4: 
			user.returnBook(database);
			break;
			
		case 5:
			scanner.readLine();
			user.addAuthor(database);
			break;
		
		
		default:
			System.out.println("!!!!! NEKOREKTN� VSTUP !!!!!\n---->Stiskni ENTER<----");
			scanner.readLine();
			break;
			
		}
		
		
			
			
		}
		
	scanner.closeScanner();	
	System.out.println("----------KONEC PROGRAMU--------------");	
		
	
	}


}
