package mojeKnihovna;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MyFileReader {
private BufferedReader readerRows;
	
	public  MyFileReader() {}
		
	public ArrayList<String> readFile(String filePath) throws IOException {
		     
		     readerRows = new BufferedReader(new FileReader(filePath,StandardCharsets.UTF_8));
		     
		     ArrayList <String> records = new ArrayList<String>();
		     String currentRecord=readerRows.readLine();
		     while (currentRecord!=null) {
		    	records.add(currentRecord);
		    	currentRecord=readerRows.readLine();
		     }
		     readerRows.close();
		     return records;
		     
		    
    }
	
}