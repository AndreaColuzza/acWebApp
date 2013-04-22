package it.geek.ufficio.DAO.imp;


import java.sql.Connection;
import java.sql.DriverManager;

import it.geek.ufficio.DAO.IDAO;
import it.geek.ufficio.model.Ruolo;
import it.geek.ufficio.model.Utente;
import it.geek.ufficio.util.MyJNDIConnection;

import java.sql.*;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

	public class RuoloDAO implements IDAO<Ruolo, String>{
		@Override
		public Ruolo findById(String id){
			
			Ruolo ret = null;
			
			Connection c = MyJNDIConnection.getConnection();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql="SELECT codruolo, descrizione FROM ruoli ";
			
			try{
				ps = c.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()){
					ret = new Ruolo();
					ret.setCodruolo(rs.getInt("codruolo"));
					ret.setDescrizione(rs.getString("descrizione"));
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
		public List<Ruolo> findAll(){
			System.out.println("RuoloDAO.findAll()::FUNZIONE NON IMPLEMENTATA");
			return null;
		}
		@Override
		public List<Ruolo> findByExample(Ruolo r) {
			
			return null;
		}

}
