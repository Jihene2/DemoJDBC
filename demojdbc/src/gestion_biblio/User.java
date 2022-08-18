package gestion_biblio;

import java.util.ArrayList;

public class User {
	
	protected int id_user;
	protected String prenom;
	protected String nom;
	protected String adress;
	protected int numTel;
	protected String mail;
	protected ArrayList<Rent> listerentuser = new ArrayList<Rent>();
	
	public User(int id_user, String prenom, String nom, String adress, int numTel, String mail,
			ArrayList<Rent> listerentuser) {
		super();
		this.id_user = id_user;
		this.prenom = prenom;
		this.nom = nom;
		this.adress = adress;
		this.numTel = numTel;
		this.mail = mail;
		this.listerentuser = listerentuser;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ArrayList<Rent> getListerentuser() {
		return listerentuser;
	}

	public void setListerentuser(ArrayList<Rent> listerentuser) {
		this.listerentuser = listerentuser;
	}
	
	
	
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", prenom=" + prenom + ", nom=" + nom + ", adress=" + adress + ", numTel="
				+ numTel + ", mail=" + mail + ", listerentuser=" + listerentuser + "]";
	}

	public void afficherlutilisateur() {
		System.out.println(toString());
	}
	public boolean Ressemblanceutlisateur(User user1, User user2) {
		boolean ressemblance=false;
		if  (user1.getId_user()==(user2.getId_user())
			& user1.getPrenom().equals(user2.getPrenom()) 
			& user1.getNom().equals(user2.getNom()))	
			
			{ressemblance=true;
		 System.out.println("le même utilisateur");
			}
		 else 
		 {  System.out.println("Différent utilisateurs");
		 }
		 
		return ressemblance;
}

	


}
