package it.geek.ufficio.DAO.imp;

import java.sql.Connection;
import java.sql.DriverManager;

import it.geek.ufficio.DAO.IDAO;
import it.geek.ufficio.model.Utente;
import it.geek.ufficio.util.MyJNDIConnection;

import java.sql.*;
import java.util.List;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UtenteDAO implements IDAO<Utente, String>{
	@Override
	public Utente findById(String id){

		Utente ret = null;

		Connection c = MyJNDIConnection.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql="SELECT username, password, cognome, nome, codruolo FROM utenti WHERE username=?";

		try{
			ps = c.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				ret = new Utente();
				ret.setUsername(rs.getString("username"));
				ret.setPassword(rs.getString("password"));
				ret.setCognome(rs.getString("cognome"));
				ret.setCodruolo(rs.getInt("codruolo"));
				ret.setNome(rs.getString("nome"));
			}
		}catch(Exception e){
			System.out.print("errore! "+e);
			e.printStackTrace();
		}finally{
			try{
				rs.close();
			}
			catch(Exception e){
				System.out.println("impossibile chiudere il ResultSet"+e.getMessage());
				e.printStackTrace();
			}
			try{
				ps.close();
			}
			catch(Exception e){
				System.out.println("impossibile chiudere il PreparedStatement "+e.getMessage());
				e.printStackTrace();
			}
			try{
				c.close();
			}
			catch(Exception e){
				System.out.println("impossibile chiudere la Connection "+e.getMessage());
				e.printStackTrace();
			}
		}
		return ret;
	}
	@Override
	public List<Utente> findAll() {

		Connection conn = MyJNDIConnection.getConnection();

		List<Utente> lista = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Utente utente = null;

		String sql = "SELECT username, password, nome, cognome, codruolo FROM utenti";

		try{
			lista = new Vector<Utente>();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();	

			while(rs.next()){

				utente = new Utente();
				utente.setCognome(rs.getString("cognome"));
				utente.setNome(rs.getString("nome"));
				utente.setUsername(rs.getString("username"));
				lista.add(utente);				 
			}
		}
		catch(Exception e){
			System.out.println("Errore " + e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
			}
			catch(Exception e){
				System.out.println("impossibile chiudere il preparedStatement " + e.getMessage());
				e.printStackTrace();
			}
			try{
				conn.close();
			}
			catch(Exception e){
				System.out.println("impossibile chiudere la Connection " + e.getMessage());
				e.printStackTrace();
			}
		}
		return lista;
}
@Override
public List<Utente> findByExample(Utente a) {

	return null;
}
}
