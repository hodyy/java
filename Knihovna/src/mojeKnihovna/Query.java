package mojeKnihovna;

public class Query {
	private StringBuilder queryBuilder;
	
	public Query select(String [] columns ) {
		queryBuilder= new StringBuilder();
		queryBuilder.append("SELECT ");
		
		if(columns.length!=0) {
			
				for(String column: columns) {
					queryBuilder.append(column+",");
				}
				queryBuilder.setLength(queryBuilder.length()-1);
		}
		else {
			queryBuilder.append("*");	
		}
		
		return this; 
		
	}
	
	
	public Query selectAllBooks() {
		queryBuilder= new StringBuilder();
		queryBuilder.append("select au.authorName, au.authorSurename, bk.* from book  bk join author au on au.`ID`=bk.`ID_author`");
		return this; 
		
	}
	
	
	public Query selectAllAuthors() {
		queryBuilder= new StringBuilder();
		queryBuilder.append("select ID, authorName, authorSurename from author");
		return this; 
		
	}
	
	
	public Query selectCount()  {
		queryBuilder= new StringBuilder();
		queryBuilder.append(" SELECT COUNT(*)");
		return this;
	}
	
	
	public Query from(String table) {
		queryBuilder.append(" FROM ");
		queryBuilder.append(table+" ");		
		return this;
	}
	
	
	public Query where(String column) {
		queryBuilder.append("WHERE "+column+"=?");
		return this;
		
	}
	
	
	public Query update(String table) {
		queryBuilder= new StringBuilder();
		queryBuilder.append("UPDATE "+table+" ");
		return this;
		
	}
	
	
	public Query set(Object object) {
		queryBuilder.append("SET "+ object+"=? ");
		return this;
	}

	
	public Query insertInTo(String table, String [] columns){
		queryBuilder=new StringBuilder();
		queryBuilder.append("INSERT INTO "+table+" (");
		for (String column: columns){
			queryBuilder.append(column+",");
		}
		queryBuilder.append(") ");
		
		queryBuilder.deleteCharAt(queryBuilder.lastIndexOf(","));
		queryBuilder.append(" VALUES (");
		
		int countOfVaulue=columns.length;
		for (int i=0;i<countOfVaulue;i++) {
			queryBuilder.append("?,");
		}
	    queryBuilder.deleteCharAt(queryBuilder.lastIndexOf(","));
	    queryBuilder.append(")");
	    return this;
		
	}
	
	
	public Query delete(String table, String [] columns) {
		queryBuilder  = new StringBuilder();
		queryBuilder.append("DELETE FROM ");
		queryBuilder.append(table + " WHERE ");
		
		for (String column: columns) {
			queryBuilder.append(column+"=?");	
		}
		return this;
	}
	
	
	public String getQuery() 
	{
		return queryBuilder.toString();
		
	}
	
	
	
	
	
	
}
