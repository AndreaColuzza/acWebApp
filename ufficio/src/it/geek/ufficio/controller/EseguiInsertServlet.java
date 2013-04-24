package it.geek.ufficio.controller;

import it.geek.ufficio.DAO.imp.UtenteDAO;
import it.geek.ufficio.model.Utente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EseguiInsertServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String codruolo = request.getParameter("codruolo");
		
		int ruolo = Integer.parseInt(codruolo);
		
		Utente utente = new Utente();
		
		utente.setUsername(username);
		utente.setPassword(password);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setCodruolo(ruolo);
		
		
		UtenteDAO dao = new UtenteDAO();
		dao.insert(utente);
		
		List<Utente> lista = dao.findAll();
		
		request.setAttribute("listaU",lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaUtenti.jsp");
		rd.forward(request,response);
		
		
	}

}
