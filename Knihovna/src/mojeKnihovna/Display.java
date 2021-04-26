package mojeKnihovna;

import java.util.ArrayList;

public class Display {

	public void showAllbooks(ArrayList<Book> books) {
		
		for(Book book: books) {
		System.out.println(book);
		}
	}
	
	public void showAllAuthors(ArrayList<Author> authors) {
		
		for(Author author: authors) {
		System.out.println(author);
		}
	}
	
}
