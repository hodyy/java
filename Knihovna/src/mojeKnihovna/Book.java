package mojeKnihovna;
import java.time.LocalDate;

public class Book {
		SingleScanner scanner = SingleScanner.getInstanceOfScanner();
	
		private String name;
		private String autor;
		private LocalDate releaseDate;	
		private Boolean borrowed=false;
		private int ID;
		
		
		public Book(String name, String autor, LocalDate releaseDate, int ID, Boolean borrowed) {
			this.name=name;
			this.autor=autor;
			this.releaseDate=releaseDate;
			this.ID=ID;
			this.borrowed=borrowed;
						
		}
		
		public String getName() {
			return name;
		}
		
		public String getAutor() {
			return autor;		
		}
		
		public LocalDate getDate() {
			return releaseDate;		
		}
		
			
		public void borrow() {
			if(!borrowed) {
				this.borrowed=true;
			}
			else {
				System.out.println("!!!!! KNIHA JE PUJČENA !!!!!\n---->Stiskni ENTER<----");
				
				scanner.readLine();			
			}			
		}
		
			
		public void returnBook() {
			if(borrowed) {
				this.borrowed=false;
			}
			else {
				System.out.println("!!!!! KNIHA JE VRÁCENA !!!!!\n---->Stiskni ENTER<----");
				scanner.readLine();		
			}			
		}
			
		public int getID() {
			return ID;
		}
		
		
		
		@Override
		public String toString() {
			String borrowedString="NE";
			if(borrowed) {
				borrowedString="ANO";				
			}
								
			return "ID:"+ID+"\n"+"Kniha: "+name+"\nAutor: "+ autor+"\nDatum vydání: "+releaseDate+"\nPujčeno: "+borrowedString+ "\n------------";		
		}			
		
	
	
		
}