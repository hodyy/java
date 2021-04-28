package mojeKnihovna;

import java.util.ArrayList;

public class Display {

	public void showAllbooks(ArrayList<Book> books) {
		System.out.println("Pøehled knih:");
		for(Book book: books) {
		System.out.println(book);
		}
	}
	
	public void showAllAuthors(ArrayList<Author> authors) {
		System.out.println("Pøehled autorù:");
		for(Author author: authors) {
		System.out.println(author);
		}
	}
	
}
