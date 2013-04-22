package it.geek.ufficio.controller;

import it.geek.ufficio.DAO.IDAO;
import it.geek.ufficio.DAO.imp.UtenteDAO;
import it.geek.ufficio.model.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doPost(request, response);
	}
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		IDAO<Utente, String> dao = new UtenteDAO();
		Utente u=(Utente)dao.findById(username);
		
		//se utente è null, vado nella pagina di errore con un messaggio...
		if(u==null){
			request.setAttribute("messaggio", "utente non trovato!");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			
		//altrimenti se la password è errata mando un messaggio diverso...
		}else if(!u.getPassword().equals(password)){
			request.setAttribute("messaggio", "password errata!");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
		//altrimenti vuol dire che è tutto ok
		else{
			HttpSession session = request.getSession();
			session.setAttribute("utente", u);

			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);								      
			
		}		

	}
}
