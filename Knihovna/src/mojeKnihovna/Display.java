package mojeKnihovna;

import java.util.ArrayList;

public class Display {

	public void showAllbooks(ArrayList<Book> books) {
		System.out.println("P�ehled knih:");
		for(Book book: books) {
		System.out.println(book);
		}
	}
	
	public void showAllAuthors(ArrayList<Author> authors) {
		System.out.println("P�ehled autor�:");
		for(Author author: authors) {
		System.out.println(author);
		}
	}
	
}
