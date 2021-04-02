package mojeKnihovna;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class Database {
	SingleScanner scanner = SingleScanner.getInstanceOfScanner();
	ArrayList <Book> bookDatabase;
	HashMap<Integer, Book> bookIndexes;
	public Database() {
		bookDatabase=new ArrayList<Book>();
		bookIndexes=new HashMap<>();
	}
	
	public void showDatabase() {
		System.out.println("\n______________AKTUÁLNÍ DATABÁZE KNIH______________\n");

		for(Book b: bookDatabase) {
			
			System.out.println(b);
			
		}
		System.out.println("__________________________________________________\n");
		
	}
		
		
	public void addBookToDatabase(Book newBook) {
		bookDatabase.add(newBook);
		bookIndexes.put(newBook.getID(), newBook);
		
		
	}
	
	public void borrowBook(int ID) {
		
			Book currentBook = bookIndexes.get(ID);
			if (currentBook!=null) {
			
				currentBook.borrow();
				}
			else{
				System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\n---->Stiskni ENTER<----\"");
				scanner.readLine();	
		}
	}
	
	
	public void returnBook(int ID) {
		
		Book currentBook = bookIndexes.get(ID);
		if (currentBook!=null) {

			currentBook.returnBook();
		}
		else {
			System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\n---->Stiskni ENTER<----\"");
			scanner.readLine();	
		}
	}
	
	
	public void deleteBookFromDatabase(int ID) {
	
		int indexCounter=0;
		
		for (Book b: bookDatabase) {
			indexCounter++;
			if(b.getID()==ID) {
				bookDatabase.remove(indexCounter-1);
				bookIndexes.remove(ID);
				return;
			}
		}
			
			System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\n---->Stiskni ENTER<----\"");
			scanner.readLine();				
	}
	
	
	public ArrayList <Book> getBooks(){
	
		return bookDatabase;
	}
	
		
					
}
	
	
