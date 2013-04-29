package it.geek.prenotazioni.DAO;

import it.geek.prenotazioni.model.Corso;
import it.geek.prenotazioni.util.MyJNDIConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class CorsoDAO {

	public List<Corso> findAll() {

		Connection conn = MyJNDIConnection.getConnection();

		List<Corso> lista = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Corso corso = null;

		String sql = "SELECT id, materia FROM corsi";

		try{
			lista = new Vector<Corso>();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();	

			while(rs.next()){

				corso = new Corso();
				corso.setId(rs.getInt("id"));
				corso.setMatricola(rs.getString("materia"));
				lista.add(corso);				 
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
}
