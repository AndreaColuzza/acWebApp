package it.geek.ufficio.controller;

import it.geek.ufficio.DAO.IDAO;
import it.geek.ufficio.DAO.imp.UtenteDAO;
import it.geek.ufficio.model.Utente;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GestioneUtentiServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		UtenteDAO dao = new UtenteDAO();
		List<Utente> lista = dao.findAll();
		
		request.setAttribute("listaU", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaUtenti.jsp");
		rd.forward(request,response);

	}
	
}
