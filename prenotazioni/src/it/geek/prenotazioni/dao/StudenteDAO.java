package it.geek.prenotazioni.DAO;

import it.geek.prenotazioni.model.Studente;
import it.geek.prenotazioni.util.MyJNDIConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudenteDAO {

	public Studente findById(String id){

		Studente stu = null;

		Connection c = MyJNDIConnection.getConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql="SELECT matricola, nome, cognome FROM studenti WHERE matricola=?";

		try{
			ps = c.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				stu = new Studente();
				stu.setMatricola(rs.getString("matricola"));
				stu.setNome(rs.getString("nome"));
				stu.setCognome(rs.getString("cognome"));				
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
		return stu;
	}
}
