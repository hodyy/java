package mojeKnihovna;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
 


public class Admin extends User {
	
	
	public Admin() {}
	
	@Override
	public void deleteBook(Database database) {
		System.out.println("Zadej ID knihy, kter� se m� odebrat:");	
		database.deleteBookFromDatabase(scanner.readInt());
		database.showDatabase();
		// NEVIM PRO� ALE MUS� TU B�T TOTO JINAK BERE VSTUP PRO DAL�� OPERACI. PRO�?????
		scanner.readLine();
	}
	
	@Override
	public void addBook(Database database) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
		RecordBuilder stringBuider=new RecordBuilder();
		
		System.out.println("Zadej N�zev knihy");
		stringBuider.addName(scanner.readLine());		

		System.out.println("Zadej Jmeno autora");
		stringBuider.addAutor(scanner.readLine());
	
		String date;
		boolean correct=false;
		boolean error;
		
		while (!correct) {
		error=false;	
		
		System.out.println("Zadej datum vyd�n� ve tvaru yyyy-mm-dd");
		date = scanner.readLine();
		
		
		try {
			formatter.parse(date);
			
		} catch (ParseException e) 
			{		
			System.out.println("\n!!!!! �PATN� ZADAN� FORMAT DATUMU  !!!!!\n---->Stiskni ENTER<----");
			scanner.readLine();
			error=true;
			}
		
		if (error==false)
		{
			stringBuider.addDate(date);
			correct=true;	
		}

		
		}

		System.out.println(stringBuider.getRecord());
		
		ArrayList <String> record = new ArrayList <String> ();
		record.add(stringBuider.getRecord());
		
		Parser parser =new Parser();
		parser.parseAndSaveToDatabase(record, database);
		
		database.showDatabase();
	
	}
		
	
}
