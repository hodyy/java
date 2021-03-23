package mojeKnihovna;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileReaderAndWriter {
private BufferedReader readeRecords;
private FileWriter writeRecords;	
	public  FileReaderAndWriter() {}
		
	public ArrayList<String> readFile(String filePath) throws IOException {
		     
			readeRecords = new BufferedReader(new FileReader(filePath,StandardCharsets.UTF_8));
		     
		     ArrayList <String> records = new ArrayList<String>();
		     String currentRecord=readeRecords.readLine();
		     while (currentRecord!=null) {
		    	records.add(currentRecord);
		    	currentRecord=readeRecords.readLine();
		     }
		     readeRecords.close();
		     return records;
		     
		    
    }
	
	public void writeToFile(ArrayList<String> books, String filePath) throws IOException {
	     
		writeRecords = new FileWriter(filePath);
		
		String empty = "empty;empty;0011-11-11";
		
		if (books.get(0)==empty) {
			writeRecords.write(" ");
	    	 writeRecords.close();
	    	 return;
		}
		else {
	
	     for (String r: books) {
	    
	     writeRecords.write(r); 	  
	    
	     }
	    
	     writeRecords.close();
	     }
	     
		}
	     
	    
}

	