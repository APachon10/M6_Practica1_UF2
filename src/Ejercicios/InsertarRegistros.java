package Ejercicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class InsertarRegistros {
	final String db_Adress = "jdbc:sqlite:../Practica1_M6_UF2_PachonAlberto_VFInal/ForHonor.db";
	public  void insertar_Faccion() {
		String query = "INSERT INTO Faccion (faccion_id, nombre_faccion, lore) VALUES(?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(db_Adress);
			PreparedStatement pt1 = conn.prepareStatement(query);
			// Caballeros
			pt1.setInt(1, 1);
			pt1.setString(2, "Caballeros");
			pt1.setString(3, "Los caballeros de Ashfeld son paradigmas del poder");
			pt1.executeUpdate();
			System.out.println("caballeros Insertados con Exito ");
			// Vikingos
			pt1.setInt(1, 2);
			pt1.setString(2, "Vikingos");
			pt1.setString(3, "Los vikingos son los maestros indiscutibles del mar y el agua");
			pt1.executeUpdate();
			System.out.println("Vikingos Insertados con Exito");
			// Samurais
			pt1.setInt(1, 3);
			pt1.setString(2, "Samurais");
			pt1.setString(3, "Los samurais son la faccion mas unificada de las tres");
			pt1.executeUpdate();
			System.out.println("Samurais Insertados con Exito ");
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	public  void insertar_Personaje() {
		String insert_personaje = "INSERT INTO Personaje (personaje_id, nombre_personaje, ataque, defensa, faccion_id) VALUES(?,?,?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(db_Adress);
			PreparedStatement pt2 = conn.prepareStatement(insert_personaje);
			
			pt2.setInt(1, 1);
			pt2.setString(2, "Guardian");
			pt2.setInt(3, 8);
			pt2.setInt(4, 5);
			pt2.setInt(5, 2);
			pt2.executeUpdate();
			
			pt2.setInt(1, 2);
			pt2.setString(2, "Guardian");
			pt2.setInt(3, 8);
			pt2.setInt(4, 3);
			pt2.setInt(5, 1);
			pt2.executeUpdate();
			
			
			pt2.setInt(1, 3);
			pt2.setString(2, "Pacificadora");
			pt2.setInt(3, 4);
			pt2.setInt(4, 8);
			pt2.setInt(5, 1);
			pt2.executeUpdate();
			

			pt2.setInt(1, 4);
			pt2.setString(2, "Pacificadora");
			pt2.setInt(3, 5);
			pt2.setInt(4, 10);
			pt2.setInt(5, 1);
			pt2.executeUpdate();

			pt2.setInt(1, 5);
			pt2.setString(2, "Berserker");
			pt2.setInt(3, 10);
			pt2.setInt(4, 10);
			pt2.setInt(5, 3);
			pt2.executeUpdate();

			pt2.setInt(1, 6);
			pt2.setString(2, "Shinnobi");
			pt2.setInt(3, 5);
			pt2.setInt(4, 9);
			pt2.setInt(5, 3);
			pt2.executeUpdate();

			pt2.setInt(1, 7);
			pt2.setString(2, "Berserker");
			pt2.setInt(3, 9);
			pt2.setInt(4, 4);
			pt2.setInt(5, 3);
			pt2.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
