package gestion_biblio;

import java.sql.Date;

public class Rent {
	
	protected int id_rent;
	protected User user;
	protected Book book;
	protected Date DatePret;
	protected Date DateFin;
	
	public Rent(int id_rent, User user, Book book, Date datePret, Date dateFin) {
		super();
		this.id_rent = id_rent;
		this.user = user;
		this.book = book;
		DatePret = datePret;
		DateFin = dateFin;
	}

	public int getId_rent() {
		return id_rent;
	}

	public void setId_rent(int id_rent) {
		this.id_rent = id_rent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getDatePret() {
		return DatePret;
	}

	public void setDatePret(Date datePret) {
		DatePret = datePret;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

	@Override
	public String toString() {
		return "Rent [id_rent=" + id_rent + ", user=" + user + ", book=" + book + ", DatePret=" + DatePret
				+ ", DateFin=" + DateFin + "]";
	}
	
	public void afficherrent() {
		System.out.println(toString());
	}

	public boolean Ressemblanceutlisateur(Rent rent1, Rent rent2) {
		boolean ressemblance=false;
		if  (rent1.getId_rent()==(rent2.getId_rent())
			& rent1.getUser().equals(rent2.getUser()) 
			& rent1.getUser().equals(rent2.getUser()))	
			
			{ressemblance=true;
		 System.out.println(" même pret");
			}
		 else 
		 {  System.out.println("Différents pret");
		 }
		return ressemblance;
	}
}
