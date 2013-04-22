package it.geek.ufficio.DAO.imp;



import it.geek.ufficio.DAO.IDAO;
import it.geek.ufficio.model.Dipartimento;
import it.geek.ufficio.util.MyJNDIConnection;

import java.sql.*;
import java.util.List;


	public class DipartimentoDAO implements IDAO<Dipartimento, String>{
		@Override
		public Dipartimento findById(String id){
			
			
			Dipartimento ret = null;
			
			Connection c = MyJNDIConnection.getConnection();
			
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
