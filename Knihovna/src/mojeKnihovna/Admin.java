package mojeKnihovna;
public class Admin extends User {
	
	
	public Admin() {}
	
	@Override
	public void deleteBook(Database database) {
		/*
		 * System.out.println("Zadej ID knihy, která se má odebrat:");
		 * database.deleteBookFromDatabase(scanner.readInt()); database.showDatabase();
		 * scanner.readLine();
		 */
	}
	
	@Override
	public void addAuthor(Database database) {
		String [] authorData= new String[2];
		
		System.out.println("Zadej jmeno autora");
		authorData [0]=scanner.readLine();
		
		System.out.println("Zadej přijmení autora");
		authorData [1]=scanner.readLine();
		
		database.addAuthor(authorData);
	
	}
	
	@Override
	public void addBook(Database database) {
		String [] bookData= new String[2];
		
		System.out.println("Zadej název knihy:");
		bookData [0]=scanner.readLine();
		
		System.out.println("Zadej datum vydání ve tvaru yyyy-mm-dd:");
		bookData [1]=scanner.readLine();
		
		Display display=new Display();
		display.showAllAuthors(database.sellectAllAuthors());
		System.out.println("Zadej ID autora:");
		int ID = scanner.readInt();
		scanner.readLine();
		
		database.addBook(bookData, ID );
	
	}
		
		
	
}
