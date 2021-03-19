package mojeKnihovna;
import java.time.LocalDate;
import java.util.Scanner;

public class library {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Database database=new Database();
		Book book1= new Book("Staøec a moøe", "Ernest Hemingway", LocalDate.of(2016, 02, 15) );
		Book book2= new Book("Kytice ", "Karel Jaromir Erben", LocalDate.now() );
				
		database.addBookToDatabase(book1);
		database.addBookToDatabase(book2);		
		database.showDatabase();
		boolean end=false;
		while (!end) {
			
		System.out.println("ZVOL OPERACI:\n\n1)Pøidat knihu - stiskni (a)\n2)Odebrat knihu - stiskni (d)\n3)Pujèit knihu: stiskni (b)\n4)Vratit knihu: stiskni (r)\n5)Ukonèit program: stiskni (e)");
		
		switch(scnr.nextLine()) {
		
		case "a":
			System.out.println("Zadej Název knihy");
			String name = scnr.nextLine();
			System.out.println("Zadej Jmeno autora");
			String autor = scnr.nextLine();
			System.out.println("Zadej datum vydání ve tvaru yyyy-mm-dd");
			String date = scnr.nextLine();
			
			Book book=new Book(name, autor,LocalDate.parse(date));
			database.addBookToDatabase(book);
			
			database.showDatabase();
			break;
			
		case "d":
			System.out.println("Zadej ID knihy, která se má odebrat:");
			
			database.deleteBookFromDatabase(scnr.nextInt());
			database.showDatabase();
			// NEVIM PROÈ ALE MUSÍ TU BÝT TOTO JINAK BERE VSTUP PRO DALŠÍ OPERACI. PROÈ?????
			scnr.nextLine();
			break;
			
		case "b":	
			System.out.println("Zadej ID knihy, kterou chceš pujèit:");
			database.borrowBook(scnr.nextInt());
			scnr.nextLine();
			database.showDatabase();
			
			
			break;
			
		case "r": 
			System.out.println("Zadej ID knihy, kterou chceš vrátit:");
			database.returnBook(scnr.nextInt());
			scnr.nextLine();
			database.showDatabase();
			break;
			
		case "e":
			end=true;
			break;
		
		
		default:
			System.out.println("!!!!! NEKOREKTNÍ VSTUP !!!!!\n---->Stiskni ENTER<----");
			scnr.nextLine();
			break;
			
		}
		
		
			
			
		}
		
	scnr.close();	
		
		
	}

}
