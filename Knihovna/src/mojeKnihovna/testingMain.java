package mojeKnihovna;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testingMain {

	public static void main(String[] args) {
		
	Display display = new Display();
	Database db = new Database("root");
	
	Query query = new Query();
	String columns []= {"ID"};
	query.delete("book", columns);
	System.out.println(query.getQuery());
	
	
		 
	}
	}


