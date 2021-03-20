package mojeKnihovna;
import java.time.LocalDate;
import java.util.Scanner;

public class Library {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Database database=new Database();
		Book book1= new Book("Sta�ec a mo�e", "Ernest Hemingway", LocalDate.of(2016, 02, 15) );
		Book book2= new Book("Kytice ", "Karel Jaromir Erben", LocalDate.now() );
				
		database.addBookToDatabase(book1);
		database.addBookToDatabase(book2);		
		database.showDatabase();
		boolean end=false;
		while (!end) {
			
		System.out.println("ZVOL OPERACI:\n\n1)P�idat knihu - stiskni (a)\n2)Odebrat knihu - stiskni (d)\n3)Puj�it knihu: stiskni (b)\n4)Vratit knihu: stiskni (r)\n5)Ukon�it program: stiskni (e)");
		
		switch(scnr.nextLine()) {
		
		case "a":
			System.out.println("Zadej N�zev knihy");
			String name = scnr.nextLine();
			System.out.println("Zadej Jmeno autora");
			String autor = scnr.nextLine();
			System.out.println("Zadej datum vyd�n� ve tvaru yyyy-mm-dd");
			String date = scnr.nextLine();
			
			Book book=new Book(name, autor,LocalDate.parse(date));
			database.addBookToDatabase(book);
			
			database.showDatabase();
			break;
			
		case "d":
			System.out.println("Zadej ID knihy, kter� se m� odebrat:");
			
			database.deleteBookFromDatabase(scnr.nextInt());
			database.showDatabase();
			// NEVIM PRO� ALE MUS� TU B�T TOTO JINAK BERE VSTUP PRO DAL�� OPERACI. PRO�?????
			scnr.nextLine();
			break;
			
		case "b":	
			System.out.println("Zadej ID knihy, kterou chce� puj�it:");
			database.borrowBook(scnr.nextInt());
			scnr.nextLine();
			database.showDatabase();
			
			
			break;
			
		case "r": 
			System.out.println("Zadej ID knihy, kterou chce� vr�tit:");
			database.returnBook(scnr.nextInt());
			scnr.nextLine();
			database.showDatabase();
			break;
			
		case "e":
			end=true;
			break;
		
		
		default:
			System.out.println("!!!!! NEKOREKTN� VSTUP !!!!!\n---->Stiskni ENTER<----");
			scnr.nextLine();
			break;
			
		}
		
		
			
			
		}
		
	scnr.close();	
		
		
	}

}
