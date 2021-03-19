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
			
			System.out.println(b);
			index++;
		}
		System.out.println("__________________________________________________\n");
		
	}
		
		
	public void addBookToDatabase(Book newBook) {
		bookDatabase.add(newBook);
		
	}
	
	public void borrowBook(int ID) {
		boolean found=false;
		for (Book b: bookDatabase) {
			if(b.getID()==ID) {
				b.borrow();		
				found=true;
				break;
			}
		}
		
		if(found==false){
			System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\n---->Stiskni ENTER<----\"");
			Scanner scanner=new Scanner(System.in);
			scanner.nextLine();
		}
		
	}
	
	
	public void returnBook(int ID) {
		boolean found=false;
		for (Book b: bookDatabase) {
			if(b.getID()==ID) {
				b.returnBook();		
				found=true;
				break;
			}
		}
		
		if(found==false){
			System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\n---->Stiskni ENTER<----\"");
			Scanner scanner=new Scanner(System.in);
			scanner.nextLine();
		}				
	}	
	
	
	public void deleteBookFromDatabase(int ID) {
	
		boolean found=false;
		int indexCounter=0;
		
		for (Book b: bookDatabase) {
			indexCounter++;
			if(b.getID()==ID) {
				bookDatabase.remove(indexCounter-1);	
				found=true;
				break;
			}
		}
		
		if(found==false){
			System.out.println("\"!!!!! ID NENI V DATABAZI  !!!!!\n---->Stiskni ENTER<----\"");
			Scanner scanner=new Scanner(System.in);
			scanner.nextLine();
		}				
	}	
		
					
			
	}
	
	
