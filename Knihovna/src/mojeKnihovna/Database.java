package mojeKnihovna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Database {
		
		Connection connection ;
		
		Query query;
		private PreparedStatement pstmt;
		private ResultSet resultSet;
		public enum status {BORROWED,NOT_EXIST, ERROR, OK, RETURNED}
			
		
		
		public Database(String name) {
			try {
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myLibrary",name,"");
				System.out.println("pøipojeno");
			} catch (SQLException e) {
				System.out.println("Nepøipojeno");
			
			}
		}
		
		public ArrayList <Book>  selectAllBooksFromDB() throws SQLException {
			query = new Query();		
			query.selectAllBooks();
			pstmt = connection.prepareStatement(query.getQuery());
			
			resultSet=pstmt.executeQuery();
			
			ArrayList <Book> result=new ArrayList<>();
			while(resultSet.next()) {
				
				String bookName = resultSet.getString("bookName");
				String authorName = resultSet.getString("authorName")+resultSet.getString("authorSurename");
				LocalDate  releaseDate= LocalDate.parse(resultSet.getString("relase_date"));
				Boolean borrowed=resultSet.getBoolean("borrowed");;
				int id = resultSet.getInt("ID");
				Book book = new Book(bookName, authorName, releaseDate, id, borrowed);
				result.add(book);
			}
			return result;
					
		}
		
		public ArrayList <Author>  sellectAllAuthors() {
			query = new Query();		
			query.selectAllAuthors();
			
			ArrayList <Author> result = new ArrayList<Author>();
			try {
				pstmt = connection.prepareStatement(query.getQuery());
				resultSet=pstmt.executeQuery();
			while(resultSet.next()) {
				
				int ID = resultSet.getInt("ID");
				String authorName = resultSet.getString("authorName");
				String authorSurename = resultSet.getString("authorSurename");
				Author author = new Author(authorName, authorSurename, ID);
				result.add(author);
				
				
			}
			} catch (SQLException e) {
				System.out.println("Chyba pøi vyhledavání autorù v DB");
				result.add(null);
				
			}
			return result;
		}
		
		
		
		private Boolean countBooks(int ID ) throws SQLException {
			Query query = new Query();
			query.selectCount().from("book").where("ID");
			pstmt = connection.prepareStatement(query.getQuery());
			pstmt.setInt(1, ID);
			
			resultSet = pstmt.executeQuery();
			resultSet.next(); 
			
			if(resultSet.getInt(1)>0){
					return true;
			}else{
					return false;
					}
								
		}
		private Boolean checkAvailability(int ID) throws SQLException  {
			Query query = new Query();
			String [] columns= {"borrowed"};
			
			query.select(columns).from("book").where("ID");
			pstmt = connection.prepareStatement(query.getQuery());
			pstmt.setInt(1, ID);
		
			resultSet=pstmt.executeQuery();
			resultSet.next(); 
			if(resultSet.getBoolean(1)){
				
					return false;
			}else{
					return true;
					}
								
		}
		;		
		
		public status borrowBook(int ID) {
			
			Query query = new Query();
			try {
				if(!countBooks(ID)){
					return status.NOT_EXIST;
				}else if(!checkAvailability(ID)) {
					return status.BORROWED;
				}else {
					query.update("Book").set("borrowed").where("ID");
					pstmt = connection.prepareStatement(query.getQuery());
					pstmt.setBoolean(1, true);
					pstmt.setInt(2, ID);
					pstmt.executeUpdate();
					return status.OK;
				}
			} catch (SQLException e) {
				System.out.println("chyba DB pøi pujèeni knihy");
				return status.ERROR;
			}
					
		}
		
	 public status returnBook(int ID) {
		 Query query = new Query();
			try {
				if(!countBooks(ID)){
					return status.NOT_EXIST;
				}else if(!checkAvailability(ID)) {
					query.update("Book").set("borrowed").where("ID");
					pstmt=connection.prepareStatement(query.getQuery());
					pstmt.setBoolean(ID, false);	
					pstmt.setInt(2, ID);
					pstmt.executeUpdate();
							return status.OK;
				}else {
					return status.RETURNED;
					
				}
			} catch (SQLException e) {
				System.out.println("chyba DB pøi vrácení knihy");
				return status.ERROR;
			}
					
		}

	 public void addAuthor(String [] authorData) {
		 Query query = new Query();
		 String [] columnsAuthor = {"authorName", "AuthorSurename" };
		 query.insertInTo("author", columnsAuthor);
		 try {
				pstmt=connection.prepareStatement(query.getQuery());
				pstmt.setString(1, authorData[0]);
				pstmt.setString(2, authorData[1]);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Chyba pøi založení autora do DB");
	 
	 }
	 }
	 	
	 public void addBook(String [] bookData, int authorID) {
		 
		 String [] columnsBook = {"bookName", "relase_date","ID_author" };
		 query.insertInTo("book", columnsBook);
		 try {
			pstmt=connection.prepareStatement(query.getQuery());
			pstmt.setString(1,bookData[0]);
			pstmt.setString(2,bookData[1]);
			pstmt.setInt(3, authorID);
		
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Chyba pøi založení knihy do DB");
		}
		 	
		
		 
	 }
	 
		
					
}
	
	
