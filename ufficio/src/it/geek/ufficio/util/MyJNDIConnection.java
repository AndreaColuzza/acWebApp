package it.geek.ufficio.util;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MyJNDIConnection {

	public static Connection getConnection(){
		
		Connection c = null;
		
		try{
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource)cxt.lookup("java:/comp/env/jdbc/UfficioDB");
			c = ds.getConnection();
		}catch(NamingException e){
			System.out.println("Impossibile trovare la risorsa");
			e.printStackTrace();
			
		}catch(SQLException e){

			System.out.println("Impossibile ottenere la connessione");
			e.printStackTrace();
		}
		return c;
	}
}