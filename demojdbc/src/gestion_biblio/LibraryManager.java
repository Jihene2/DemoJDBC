package gestion_biblio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class LibraryManager {

		public static void main(String[] args)  {
		
			Connection cn = connecterDB();
			afficherlelivre();
	//		ajouterunlivre(7, "1984", "George orwell", "EAN", 438, "résumé", 1);
			recherchelivreparID(3);
			recherchelivreparAuteur("Albert camus");
			livrepret();
			livreUser(2);
			rechercheUserparID(4);
		//	createUser(15,"mohamed", "ali", "tunis", 52081555, "mohamed.ali@gmail.com",1);
			 
			
		
		}
		
		// Fonction connecteur base de données
		public static Connection connecterDB() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver ok");
				String url = "jdbc:mysql://localhost/gestion_bibliothèque";
				String login = "root";
				String passwd = "";
				Connection cn = DriverManager.getConnection(url, login, passwd);
				System.out.println("connexion établie");
				return cn;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		// Fonction afficher un livre
		 public static void afficherlelivre() {
			   try {
				   Connection cn = connecterDB();
				   Statement st ;
				   ResultSet rst;
				   st= cn.createStatement();
				   rst=st.executeQuery("SELECT * FROM book");
				   while(rst.next()) {
					   System.out.println(rst.getInt("id_book"));
						System.out.println(rst.getString("title"));
						System.out.println(rst.getString("author"));
						System.out.println(rst.getString("editor"));
						System.out.println(rst.getInt("pageNb"));
						System.out.println(rst.getString("summary"));
						System.out.println(rst.getInt("library"));
						System.out.println();
				   }
			   }catch (Exception ex) {
				   ex.printStackTrace();
			   }
		   }
		 // Fonction ajouter un livre
		 public static void ajouterunlivre(int id_book, String title, String author,String editor,int pageNb,String summary,int library ) {
			 try {
				   Connection cn = connecterDB();
				   Statement st ;
				   st= cn.createStatement();
				   st.executeUpdate("INSERT INTO `book` (`id_book`, `title`, `author`, `editor`, `pageNb`, `summary`, `library`) VALUES ("+id_book+", '"+title+"', '"+author+"', '"+editor+"', "+pageNb+", '"+summary+"', "+library+")");
				   System.out.println("Ajout  approuvé");
				  
			   }catch (Exception ex) { 
				   ex.printStackTrace();
			   }
		 }
		 
		 // Fonction recherche d'un livre par son ID
		 
		 public static void recherchelivreparID(int id_book) {
			 try {
				 Connection cn = connecterDB();
				   Statement st ;
				   ResultSet rst;
				   st= cn.createStatement();
				   rst=st.executeQuery("SELECT * FROM book WHERE id_book="+id_book+"");
				   System.out.println("le livre recherché par ID :");
				   while(rst.next()) {
					   System.out.println(rst.getInt("id_book"));
					   System.out.println(rst.getString("title"));
						System.out.println(rst.getString("author"));
						System.out.println(rst.getString("editor"));
						System.out.println(rst.getInt("pageNb"));
						System.out.println(rst.getString("summary"));
						System.out.println(rst.getInt("library"));
						
				   }
			   }catch (Exception ex) {
				   ex.printStackTrace();
		 }
		 }
		 
		 //Fonction recherche d'un livre par son auteur 
       public static void recherchelivreparAuteur(String Auteur) {
	     try {
		 Connection cn = connecterDB();
		   Statement st ;
		   ResultSet rst;
		   st= cn.createStatement();
		   rst=st.executeQuery("SELECT * FROM book WHERE author='"+Auteur+"'");
		   System.out.println("le livre recherché par auteur :");
		   while(rst.next()) {
			   System.out.println(rst.getInt("id_book"));
			   System.out.println(rst.getString("title"));
				System.out.println(rst.getString("author"));
				System.out.println(rst.getString("editor"));
				System.out.println(rst.getInt("pageNb"));
				System.out.println(rst.getString("summary"));
				System.out.println(rst.getInt("library"));
				
		   }
	   }catch (Exception ex) {
		   ex.printStackTrace();
 }
 }
       //afficher les livres en cours de prêt de la bibliothèque passée en paramètre

      public static void livrepret() {
        try {
	   Connection cn = connecterDB();
	   Statement st ;
	   ResultSet rst;
	   st= cn.createStatement();
	   rst=st.executeQuery("SELECT id_book,ref_book, title,author,editor,pageNb FROM rent, book WHERE rent.ref_book=book.id_book");
	   System.out.println("les livres prêtés:");
	   while(rst.next()) {
		   System.out.println(rst.getInt("id_book"));
		   System.out.println(rst.getString("title"));
			System.out.println(rst.getString("author"));
			System.out.println(rst.getString("editor"));
			System.out.println(rst.getInt("pageNb"));
			
			
	   }
  }catch (Exception ex) {
	   ex.printStackTrace();
}
      }
      //afficher les livres en cours de prêt d'un utilisateur passé en paramètre
      
      public static void livreUser(int id_user) {
          try {
  	   Connection cn = connecterDB();
  	   Statement st ;
  	   ResultSet rst;
  	   st= cn.createStatement();
  	   rst=st.executeQuery("SELECT id_user,ref_user, id_book,ref_book, title,author,editor,pageNb FROM rent, book,user WHERE rent.ref_book=book.id_book AND "+id_user+"=rent.ref_user"  );
  	   System.out.println("les livres de l'utisateur sont:");
  	   while(rst.next()) {
  		   System.out.println(rst.getInt("id_book"));
  		   System.out.println(rst.getString("title"));
  			System.out.println(rst.getString("author"));
  			System.out.println(rst.getString("editor"));
  			System.out.println(rst.getInt("pageNb"));
  			
  			
  	   }
    }catch (Exception ex) {
  	   ex.printStackTrace();
}
      }
      //recherche d'un utilisateur par son ID
      
 	 public static void rechercheUserparID(int id_user) {
		 try {
			 Connection cn = connecterDB();
			   Statement st ;
			   ResultSet rst;
			   st= cn.createStatement();
			   rst=st.executeQuery("SELECT * FROM user WHERE id_user="+id_user+"");
			   System.out.println("le livre recherché par ID :");
			   while(rst.next()) {
				   System.out.println(rst.getInt("id_user"));
				   System.out.println(rst.getString("prenom"));
					System.out.println(rst.getString("nom"));
					System.out.println(rst.getString("adress"));
					System.out.println(rst.getInt("numTel"));
					System.out.println(rst.getString("mail"));
					
			   }
		   }catch (Exception ex) {
			   ex.printStackTrace();
	 }
	 }
 	//Une méthode permettant de créer un utilisateur
 	 
 
	 public static void createUser(int id_user, String prenom, String nom,String adress,int numTel,String mail,int ref_rent ) {
		 try {
			   Connection cn = connecterDB();
			   Statement st ;
			   st= cn.createStatement();
			   st.executeUpdate("INSERT INTO `user` (`id_user`, `prenom`, `nom`, `adress`, `numTel`, `mail`, `ref_rent`) VALUES ("+id_user+", '"+prenom+"', '"+nom+"', '"+adress+"', "+numTel+", '"+mail+"',"+ref_rent+")");
			   System.out.println("utilisateur ajouté avec succés");
			  
		   }catch (Exception ex) { 
			   ex.printStackTrace();
		   }
		 
		 
	 }
	 
	 // Une méthode permettant de créer un prêt;
	 
	 public static void createRent(int id_rent, Date DatePret , Date DateFin,int ref_book,int ref_user) {
		 try {
			   Connection cn = connecterDB();
			   Statement st ;
			   st= cn.createStatement();
			   st.executeUpdate("INSERT INTO `rent` (`id_rent`, `DatePret`, `DateFin`, `ref_book`, `ref_user`) VALUES ("+id_rent+", "+DatePret+", "+DateFin+", "+ref_book+", "+ref_user+")");
			   System.out.println("Prêt ajouté avec succés");
			  
		   }catch (Exception ex) { 
			   ex.printStackTrace();
		   }
}
}
