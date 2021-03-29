package mojeKnihovna;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RecordBuilder {
		private String name;
		private String autor;
		private String date;
		private Database database;
		
		public RecordBuilder(Database database) {	
			this.database=database;
			
			
		}
		
		
		
		
		public void addName(String name) {
			this.name=addSemicolon(name);
			
			
		}
		
		public void addAutor(String autor) {
			this.autor=addSemicolon(autor);
			
			
		}
		
		public boolean addDate(String date) {
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
			boolean error=false;
			
			try {
				formatter.parse(date);
				
			} catch (ParseException e) 
				{		
				error=true;
				}
			
			if(error==false) {
			this.date=addSemicolon(date);
			processRecord();
			return true;
			}
			else {
				return false;
			}
		}
		
		
		private String addSemicolon(String record) {
			
			record=record+";";
			return record;
			
		}
		private String getRecord () {
			return name+autor+date;		
		}
		
		private void processRecord() {
			
			ArrayList <String> record = new ArrayList <String> ();
			record.add(getRecord());
			
			Parser parser =new Parser();
			parser.parseAndSaveToDatabase(record, database);
			
		}
		
		
}

