package org.crud.region;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.jar.Attributes.Name;

import javax.naming.spi.DirStateFactory.Result;


public class CRUDS_REGION {
		static Connection connection;
		static String driver = "oracle.jdbc.driver.OracleDriver";
		static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";

		public static void connectionOracleDataBase()throws IOException, SQLException{
			
			try {
				Class.forName(driver).newInstance();
				System.out.println("CARGO DRIVER CORRECTAMENTE");
			} catch (Exception e) {
				System.out.println("exception;"+ e.getMessage());
			}
			
			try {
				connection = DriverManager.getConnection(URL,"System","Inukira17");
				System.out.println("CONEXIÓN EXITOSA A ORACLE DATA BASE");
			} catch (Exception e) {
				System.out.println("exception;"+ e.getMessage());
			}
			
			
		}
		
		public static void agregarS_Region(int id, String name) throws IOException, SQLException {
			
			try { 
				connectionOracleDataBase();
				//consulta
				String sql ="INSERT INTO S_REGION (ID,NAME) VALUES(?,?)";
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setInt(1,id);
				ps.setNString(2, name);
				ps.executeQuery();
				ps.close();
				System.out.println("Inserto "+id+", "+name);
				
			} catch (Exception e) {
				System.out.println("exception;"+ e.getMessage());
			}
			
		}

		public static void eliminarS_Region(int id, String name) throws IOException, SQLException {
			
			try { 
				connectionOracleDataBase();
				//consulta
				String sql ="DELETE FROM S_REGION WHERE ID = ?";
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setInt(1,id);
				
				ps.executeQuery();
				ps.close();
				System.out.println("ELIMINO "+id+", "+name);
				
			} catch (Exception e) {
				System.out.println("exception;"+ e.getMessage());
			}
			
		}

public static void consultaS_Region(int id) throws IOException, SQLException {
			
			try { 
				connectionOracleDataBase();
				//consulta
				String sql ="SELECT * FROM S_REGION";
				PreparedStatement ps=connection.prepareStatement(sql);
				
				ResultSet rSet= ps.executeQuery();
				while (rSet.next()) {
				System.out.println(rSet.getInt("id")+", "+rSet.getString("name"));
				}
			} catch (Exception e) {
				System.out.println("exception;"+ e.getMessage());
			}
			
		}

public static void consulta_GS_Region(int id) throws IOException, SQLException {
	
	try { 
		connectionOracleDataBase();
		//consulta
		connectionOracleDataBase();
		//CONSULTA
		String sql = "SELECT * FROM S_REGION";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rSet = ps.executeQuery();
		while (rSet.next()) {
			System.out.println(rSet.getInt("id")+", "+rSet.getString("name"));
		}
	} catch (Exception e) {
		System.out.println("exception;"+ e.getMessage());
	}
	
}

public static void procS_Region(int id, String name) throws IOException, SQLException {
	
	try { 
		connectionOracleDataBase();
		//consulta
		CallableStatement cs= connection.prepareCall("CALL proc(?,?)");
		cs.setInt(1, id);
		cs.setString(2, name);
		cs.execute();
		
	} catch (Exception e) {
		System.out.println("exception;"+ e.getMessage());
	}
	
}

		
		public static void main (String[] args) throws IOException,SQLException{
			consulta_GS_Region(2);
			
		}
}
