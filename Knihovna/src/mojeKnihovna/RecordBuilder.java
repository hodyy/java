package mojeKnihovna;

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
		
		public void addDate(String date) {
			this.date=addSemicolon(date);
			
		}
		
		
		private String addSemicolon(String record) {
			
			record=record+";";
			return record;
			
		}
		public String getRecord() {
			return name+autor+date;
			
		}
		
		
}

