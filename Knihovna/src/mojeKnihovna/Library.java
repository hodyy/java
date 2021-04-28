package mojeKnihovna;

 class Library {

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
		
		Database database =new Database("root");
		Display display=new Display();
		
		boolean end=false;
		while (!end) {
			
		display.showAllbooks(database.selectAllBooksFromDB());			
		System.out.println("----------Stiskni ENTER --------");
		scanner.readLine();
			
		System.out.println("ZVOL OPERACI:\n\n1)Pøidat knihu\n2)Odebrat knihu\n3)Pujèit knihu:\n4)Vratit knihu:\n5)Pøidat autora:\n6)KONEC:");
		
		switch(scanner.readInt()) {
		
		case 1:
			scanner.readLine();
			user.addBook(database);
			break;
			
		case 2:
			scanner.readLine();
			user.deleteBook(database); 
			break;	
			
		case 3:	
			scanner.readLine();
			user.borrowBook(database);

			break;
		
		case 4: 
			scanner.readLine();
			user.returnBook(database);
			
			break;
			
		case 5:
			scanner.readLine();
			user.addAuthor(database);
			break;
			
		case 6:
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
