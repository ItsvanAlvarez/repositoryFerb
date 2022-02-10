package org.crud.Producto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.net.aso.s;


public class CRUDS_PRODUCTO {
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
			//	System.out.println("CONEXIÓN EXITOSA A ORACLE DATA BASE");
			} catch (Exception e) {
			//	System.out.println("exception;"+ e.getMessage());
			}
			
			
		}
		
		public static void agregarS_Producto(int id, String name,String SHORT_DESC, int LONGTEXT_ID, int IMAGE_ID, int SUGGESTED_WHLSL_PRICE, String WHLSL_UNITS) throws IOException,SQLException{
			try {
				connectionOracleDataBase();
				//CONSULTA
				String sql = "insert into S_PRODUCT (ID, NAME, SHORT_DESC,LONGTEXT_ID,IMAGE_ID,"
						+ "SUGGESTED_WHLSL_PRICE,WHLSL_UNITS) values (?,?,?,?,?,?,?)";
				
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3,SHORT_DESC);
				ps.setInt(4,LONGTEXT_ID);
				ps.setInt(5,IMAGE_ID);
				ps.setInt(6,SUGGESTED_WHLSL_PRICE);
				ps.setString(7,WHLSL_UNITS);				
				ps.executeQuery();
				ps.close();
				connection.close();
				System.out.println(sql);
				System.out.println("INSERTO: " + id + "," + name + ","+ SHORT_DESC +"," +LONGTEXT_ID+","+IMAGE_ID+
						","+SUGGESTED_WHLSL_PRICE+","+WHLSL_UNITS);
			} catch (Exception e) {
				System.out.println("Exception:" + e.getMessage());
			}
		}		
public static void main (String[] args) throws IOException,SQLException{
	
	 agregarS_Producto(1, "s", "A", 1, 2,5, "SA");
	 
	 //actualizarS_Articulo("galletas", 1001, 12);
	//eliminarS_Articulo(1001);
	//consultaIndividualS_Articulo(2);
}
}
