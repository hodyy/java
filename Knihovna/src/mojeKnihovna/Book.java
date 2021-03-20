package mojeKnihovna;

import java.time.LocalDate;
import java.util.Scanner;
public class Book {
		private String name;
		private String autor;
		private LocalDate releaseDate;	
		private Boolean borrowed=false;
		static int staticID=0;
		private final int ID;
		
		
		public Book(String name, String autor, LocalDate releaseDate) {
			this.name=name;
			this.autor=autor;
			this.releaseDate=releaseDate;
			staticID++;
			this.ID=staticID;				
		}
		
			
		public void borrow() {
			if(!borrowed) {
				this.borrowed=true;
			}
			else {
				System.out.println("!!!!! KNIHA JE PUJÈENA !!!!!\n---->Stiskni ENTER<----");
				Scanner scanner=new Scanner(System.in);
				scanner.nextLine();			
			}			
		}
		
		
		public void returnBook() {
			if(borrowed) {
				this.borrowed=false;
			}
			else {
				System.out.println("!!!!! KNIHA JE VRÁCENA !!!!!\n---->Stiskni ENTER<----");
				Scanner scanner=new Scanner(System.in);
				scanner.nextLine();				
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
								
			return "ID:"+ID+"\n"+"Kniha: "+name+"\nAutor: "+ autor+"\nDatum vydání: "+releaseDate+"\nPujèeno: "+borrowedString+ "\n------------";		
		}				
}
