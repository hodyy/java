package mojeKnihovna;

import java.time.LocalDate;

public class Parser {
	String [] booksRecords;
	
	public Parser() {}
	
	public void parseAndSaveToDatabase(String [] booksRecords, Database database) {
		
		int lenght = booksRecords.length;
		String [] record;
		int year;
	    int month;
	    int day;
	    String [] date;
	    
		for (int i=0;i<lenght;i++) {
			record = booksRecords[i].split(";");
			date=record[2].split("-");
			year=Integer.parseInt(date[0]);
	    	month=Integer.parseInt(date[1]);
	    	day=Integer.parseInt(date[2]);
	    	Book currentBook = new Book(record[0],record[1],LocalDate.of(year, month, day));	
	    	database.addBookToDatabase(currentBook);
		}
		
		
		
	}
	
}
