package it.geek.prenotazioni.DAO;

import it.geek.prenotazioni.model.Prenotazione;
import it.geek.prenotazioni.util.MyJNDIConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PrenotazioneDAO {

	public boolean insert(String matricola,int corso){
		
		
		Connection conn = MyJNDIConnection.getConnection();
		boolean ret = false;
		
		String sql = "INSERT INTO prenotazioni (cod_studente, cod_corso) values(?,?)";
		
		PreparedStatement ps = null;
		
		try{
		
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,matricola);
			ps.setInt(2,corso);
    
            int ritorno = ps.executeUpdate();	
			
			if(ritorno>0){
				ret=true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}	
		finally {
			try{
				ps.close();
			}
			catch(Exception e){
				System.out.println("Impossibile chiudere il PreparedStatement .... "+e);
				e.printStackTrace();
			}
			try{
				conn .close();
			}
			catch(Exception e){
				System.out.println("Impossibile chiudere la Connection .... "+e);
				e.printStackTrace();
			}
		}
	    return ret;
	}


}
