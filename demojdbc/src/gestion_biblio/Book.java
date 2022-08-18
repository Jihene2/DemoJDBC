package gestion_biblio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book {
	
	protected int id_book;
	protected String title;
	protected String author;
	protected String editor;
	protected int pageNb;
	protected String summary;
	protected Library Library;
	
	public Book(int id, String title, String author, String editor, int pageNb, String summary, String library) {
		super();
		this.id_book = id_book;
		this.title = title;
		this.author = author;
		this.editor = editor;
		this.pageNb = pageNb;
		this.summary = summary;
		this.Library = Library;
	}

	

	public int getId_book() {
		return id_book;
	}



	public void setId_book(int id_book) {
		this.id_book = id_book;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getPageNb() {
		return pageNb;
	}

	public void setPageNb(int pageNb) {
		this.pageNb = pageNb;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


	
	
	public Library getLibrary() {
		return Library;
	}



	public void setLibrary(Library library) {
		Library = library;
	}



	@Override
	public String toString() {
		return "Book [id=" + id_book + ", title=" + title + ", author=" + author + ", editor=" + editor + ", pageNb="
				+ pageNb + ", summary=" + summary + ", Library=" + Library + "]";
	}
	
	

	public void afficherlelivre() {
		System.out.println(toString());
	}
	
	
		public boolean RessemblanceLivre(Book livre1, Book livre2) {
			boolean ressemblance=false;
			if  (livre1.getId_book()==(livre2.getId_book())
				& livre1.getTitle().equals(livre2.getTitle()) 
				& livre1.getAuthor().equals(livre2.getAuthor()) 
				& livre1.getEditor().equals(livre2.getEditor())
				& livre1.getSummary().equals(livre2.getSummary()))
				
				{ressemblance=true;
			 System.out.println("le même livre");
				}
			 else 
			 {  System.out.println("Différents livres");
			 }
			 
			return ressemblance;
	}
	
	

}
