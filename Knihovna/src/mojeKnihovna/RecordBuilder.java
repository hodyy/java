package mojeKnihovna;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RecordBuilder {
		private String name;
		private String autor;
		private String date;
		
		public RecordBuilder() {}
		
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
		public String getRecord() {
			return name+autor+date;
			
		}
		
		
}

