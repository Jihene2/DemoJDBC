package com.objis.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbc {

	public static void main(String[] args) {
		sauverEnBase("Jean DUPONT");
		
	}

	public static void sauverEnBase(String personne) {

		// Information d'acc?s ? la base de donn?es
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String passwd = "";
		Connection cn =null;
		Statement st =null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Etape 2 : r?cup?ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr?ation d'un statement
			st = cn.createStatement();

			String sql = "INSERT INTO `javadb` (`personne`) VALUES ('"
					+ personne + "')";

			// Etape 4 : ex?cution requ?te
			st.executeUpdate(sql);

			// Si r?cup donn?es alors ?tapes 5 (parcours Resultset)

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
			// Etape 6 : lib?rer ressources de la m?moire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
		}