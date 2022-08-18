package gestion_biblio;

import java.util.ArrayList;



public class Library {
	protected int id_library;
	protected String name;
	protected String adress;
	protected int numTel;
	protected ArrayList<Book> listebook = new ArrayList<Book>();
	protected ArrayList<Rent> listerent = new ArrayList<Rent>();
	
	public Library(int id_library, String name, String adress, int numTel, ArrayList<Book> listebook,
			ArrayList<Rent> listerent) {
		super();
		this.id_library = id_library;
		this.name = name;
		this.adress = adress;
		this.numTel = numTel;
		this.listebook = listebook;
		this.listerent = listerent;
	}

	public int getId_library() {
		return id_library;
	}

	public void setId_library(int id_library) {
		this.id_library = id_library;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public ArrayList<Book> getListebook() {
		return listebook;
	}

	public void setListebook(ArrayList<Book> listebook) {
		this.listebook = listebook;
	}

	public ArrayList<Rent> getListerent() {
		return listerent;
	}

	public void setListerent(ArrayList<Rent> listerent) {
		this.listerent = listerent;
	}
	
	
	
	
	
}