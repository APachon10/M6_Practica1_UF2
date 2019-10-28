package Ejercicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class CrearTablas {
	final String db_Adress = "jdbc:sqlite:../Practica1_M6_UF2_PachonAlberto_VFInal/ForHonor.db";
	
	public  void crear_tablaFaccion() {
		String creacion_tabla2 = "CREATE TABLE IF NOT EXISTS Faccion (faccion_id integer PRIMARY KEY, nombre_faccion text(15), lore text(200));";
		try {
			Connection conn = DriverManager.getConnection(db_Adress);
			Statement stmt = conn.createStatement();
			stmt.execute(creacion_tabla2);
			System.out.println("\nTabla 'Faccion' creada.");
		} catch (Exception  e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public  void crear_tablaPersonaje() {
		String creacion_tabla = "CREATE TABLE IF NOT EXISTS Personaje (personaje_id integer PRIMARY KEY, nombre_personaje text(15), ataque integer, defensa integer, faccion_id integer, FOREIGN KEY (faccion_id) REFERENCES Faccion(faccion_id));";
		try {
			Connection conn = DriverManager.getConnection(db_Adress);
			Statement stmt = conn.createStatement();
			stmt.execute(creacion_tabla);
			System.out.println("Tabla 'Personaje' creada.");
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
