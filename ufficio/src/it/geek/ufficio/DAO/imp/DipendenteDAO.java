package it.geek.ufficio.DAO.imp;

import java.sql.Connection;
import java.sql.DriverManager;

import it.geek.ufficio.DAO.IDAO;
import it.geek.ufficio.model.Dipendente;
import it.geek.ufficio.model.Utente;
import it.geek.ufficio.util.MyJNDIConnection;

import java.sql.*;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

	public class DipendenteDAO implements IDAO<Dipendente, String>{
		@Override
		public Dipendente findById(String id){
			
			
			Dipendente ret = null;
			
			Connection c = MyJNDIConnection.getConnection();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql="SELECT qualifica, telefonoufficio FROM dipendenti WHERE qualifica=?";
			
			try{
				ps = c.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()){
					ret = new Dipendente();
					ret.setQualifica(rs.getString("qualifica"));
					ret.setTelefonoufficio(rs.getInt("telefonoufficio"));
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
		public List<Dipendente> findAll(){
			System.out.println("DipendenteDAO.findAll()::FUNZIONE NON IMPLEMENTATA");
			return null;
		}
		@Override
		public List<Dipendente> findByExample(Dipendente d) {
			
			return null;
		}
		@Override
		public boolean insert(Utente u) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean update(Utente u) {
			// TODO Auto-generated method stub
			return false;
		}
}
