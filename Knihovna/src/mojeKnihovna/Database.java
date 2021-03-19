package mojeKnihovna;
import java.util.ArrayList;
import java.util.Scanner;


public class Database {

	ArrayList <Book> bookDatabase;
	
	public Database() {
		bookDatabase=new ArrayList<Book>();
		
	}
	
	public void showDatabase() {
		System.out.println("\n______________AKTUÁLNÍ DATABÁZE KNIH______________\n");
		int index=0;
		for(Book b: bookDatabase) {
			
			System.out.println("ID: "+index+b);
			index++;
		}
		System.out.println("__________________________________________________\n");
		
	}
		
		
	public void addBookToDatabase(Book newBook) {
		bookDatabase.add(newBook);
		
	}
	
	public void borrowBook(int index) {
		
		int length=bookDatabase.size();
		if (index>length)
		{
			System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\\n---->Stiskni ENTER<----\"");
			Scanner scanner=new Scanner(System.in);
			scanner.nextLine();
			
			
			
		}
		else {
			
		Book book = bookDatabase.get(index);
		book.borrow();
			
		}
		
	}
	
	public void returnBook(int index) {
	
		int length=bookDatabase.size();
		if (index>length)
		{
		
			System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\\n---->Stiskni ENTER<----\"");
			Scanner scanner=new Scanner(System.in);
			scanner.nextLine();
			
			
			
		}
		else {
			Book book = bookDatabase.get(index);
			book.returnBook();
			
			
		}
		
				
	}	
	
	
	public void deleteBookFromDatabase(int index) {
		
	int length=bookDatabase.size();
	if (index>length)
	{
		System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\\n---->Stiskni ENTER<----\"");
		Scanner scanner=new Scanner(System.in);
		scanner.nextLine();
		
		
		
		
	}
	else {
		
		bookDatabase.remove(index);
		
	}
		
		
	
		
	}
		
	
	
			
			
			
	}
	
	
