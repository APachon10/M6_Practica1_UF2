package Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	static final String db_Adress = "jdbc:sqlite:../Practica1_M6_UF2_PachonAlberto_VFInal/ForHonor.db";

	public static void main(String[] args) {
		connect();
		
		CrearTablas c = new CrearTablas();
		c.crear_tablaFaccion();
		c.crear_tablaPersonaje();
		
		InsertarRegistros ir = new InsertarRegistros();
		ir.insertar_Faccion();
		ir.insertar_Personaje();
		
		//Ejercicios Aqui!!!
		System.out.println("=======================");
		Ej1();
		System.out.println("=======================");
		Ej2();
	}
	public static void connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(db_Adress);
			System.out.println("BD ForHonor conectada.");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
		
	/*Ejercicio donde hacemos un select de la tabla personajes */
	public static void Ej1() {
		String Select_Personajes = "SELECT * FROM Personaje";
		try {
			Connection conn = DriverManager.getConnection(db_Adress);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Select_Personajes);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4)
						+ "\t" + rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/*Ejercicio donde hacemos un select donde buscamos a los personajes pertenecientes a la faccion caballeros*/
	public static void Ej2() {
		String Select_Caballeros = "SELECT * FROM Personaje WHERE faccion_id = 1";
		try {
			Connection conn = DriverManager.getConnection(db_Adress);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Select_Caballeros);
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4)
						+ "\t" + rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
