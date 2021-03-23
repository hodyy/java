package mojeKnihovna;

import java.time.LocalDate;
import java.util.ArrayList;

public class Parser {
	String [] booksRecords;
	
	public Parser() {}
	
	public void parseAndSaveToDatabase(ArrayList <String> booksRecords, Database database) {
		System.out.println(booksRecords.size());
		if(booksRecords.size()==0) {
			return;
		}
		
		String [] record;
		int year;
	    int month;
	    int day;
	    String [] date;
	    
		for (String r: booksRecords) {
			record = r.split(";");
			date=record[2].split("-");
			year=Integer.parseInt(date[0]);
	    	month=Integer.parseInt(date[1]);
	    	day=Integer.parseInt(date[2]);
	    	Book currentBook = new Book(record[0],record[1],LocalDate.of(year, month, day));	
	    	database.addBookToDatabase(currentBook);
		}
		
		
		
		
	}
		public ArrayList <String> parseBeforeWrite(ArrayList <Book> booksDatabase) {
			ArrayList <String> records = new ArrayList<>();
			if(booksDatabase.size()==0) {
				return records;
				}
			
			for (Book b: booksDatabase) {
				String name=b.getName();
				String autor=b.getAutor();
				String date= b.getDate().toString();
				String record=name+";"+autor+";"+date;
				records.add(record);
							
				
			}
			
			return records;
			
		
		}
	
	
	
}
