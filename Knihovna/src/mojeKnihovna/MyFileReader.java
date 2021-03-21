package mojeKnihovna;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class MyFileReader {

	private BufferedReader reader;
	
	public void MyFilerReader() {}
		
	public void readFile(String filePath, Database database) throws IOException {
		     
		     reader = new BufferedReader(new FileReader(filePath,StandardCharsets.UTF_8));
		     String currentLine=" ";
		     String [] record;
		     String [] date;
		     int year;
		     int month;
		     int day;
		     
		     while (currentLine!=null) {
		    	 
		    	currentLine=reader.readLine();
		    	
		    	 if(currentLine!=null){
		    	record =currentLine.split(";");
		    	date=record[2].split("-");
		    	
		    	year=Integer.parseInt(date[0]);
		    	month=Integer.parseInt(date[1]);
		    	day=Integer.parseInt(date[2]);
		    	
		    	Book currentBook = new Book(record[0],record[1],LocalDate.of(year, month, day));	
		    	database.addBookToDatabase(currentBook);
		    	 }
		     }
		   	 
		     reader.close();
		   
		
		
	}


	}
	
	
	

