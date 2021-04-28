package mojeKnihovna;

public class Author {
		private String name;
		private String sureName;
		private int  ID;
		
		public Author(String name, String sureName, int ID) {
			this.name=name;
			this.sureName=sureName;
			this.ID=ID;	
		}
	
		
		@Override
		public String toString() {					
			return "ID:"+ID+"\n"+"Jméno: "+name+"\nPøíjmení: "+ sureName+"\n------------";		
		}	
	
  }
