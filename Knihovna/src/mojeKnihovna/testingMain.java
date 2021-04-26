package mojeKnihovna;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testingMain {

	public static void main(String[] args) {
		
	
		Database db = new Database("root");
		PreparedStatement pstmt;
		 Query query = new Query();
		 String [] columnsAuthor = {"authorName", "AuthorSurename" };
		 query.insertInTo("author", columnsAuthor);
		 System.out.println(query.getQuery());
		
		 
	}
	}


