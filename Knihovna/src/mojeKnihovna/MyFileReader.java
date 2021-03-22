package mojeKnihovna;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyFileReader {
private BufferedReader readerRows;
private BufferedReader readerRecords;
	
	public void MyFilerReader2() {}
		
	public String [] readFile(String filePath) throws IOException {
		     
		     readerRows = new BufferedReader(new FileReader(filePath,StandardCharsets.UTF_8));
		     readerRecords = new BufferedReader(new FileReader(filePath,StandardCharsets.UTF_8));
		     Scanner sc = new Scanner(filePath);
		     int count=0;
		     
		     while (readerRows.readLine()!=null) {
		    	
		    	 count++;
		     }
		     readerRows.close();
		     sc.close();
		     
		     String [] records = new String[count];
		     int index=0;
		     String currentLine=" ";
		     
		     while (currentLine!=null) {
		    	 currentLine=readerRecords.readLine();
		    	 if (currentLine!=null){
		    	 records[index]=currentLine;
		    	 index++;
		    	 }
		     }
		     
		     readerRecords.close();
		   	 return records;
    }
	
}