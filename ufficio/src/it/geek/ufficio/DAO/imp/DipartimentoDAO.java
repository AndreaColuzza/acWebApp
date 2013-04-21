package it.geek.ufficio.DAO.imp;

import java.sql.DriverManager;

import it.geek.ufficio.DAO.IDAO;
import it.geek.ufficio.model.Dipartimento;
import java.sql.*;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

	public class DipartimentoDAO implements IDAO<Dipartimento, String>{
		@Override
		public Dipartimento findById(String id){
			
			Connection c = null;
			Dipartimento ret = null;
			
			try{
				InitialContext cxt = new InitialContext();
				DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/ufficioDB" );
				c = ds.getConnection();
				}
				/*Class.forName("com.mysql.jdbc.Driver");
				c = DriverManager.getConnection("jdbc:mysql://localhost/musica?user=root&password=root");*/
			catch(NamingException e){
					System.out.println("non ho la risorsa");
					e.printStackTrace();
				}
			/*catch(ClassNotFoundException e){
				System.out.println("non ho trovato il driver");
				e.printStackTrace();
				*/
			catch(SQLException e){
				System.out.println("non ho la connessione");
				e.printStackTrace();
			}
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql="SELECT numerodipartimento FROM dipartimenti";
			try{
				ps = c.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()){
					ret = new Dipartimento();
					ret.setNumerodipartimento(rs.getInt("numerodipartimento"));
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
		public List<Dipartimento> findAll(){
			System.out.println("DipartimentoDAO.findAll()::FUNZIONE NON IMPLEMENTATA");
			return null;
		}
		@Override
		public List<Dipartimento> findByExample(Dipartimento di) {
			
			return null;
		}
}
