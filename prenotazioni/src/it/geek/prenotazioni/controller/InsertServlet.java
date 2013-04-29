package it.geek.prenotazioni.controller;

import it.geek.prenotazioni.DAO.PrenotazioneDAO;
import it.geek.prenotazioni.model.Prenotazione;
import it.geek.prenotazioni.model.Studente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InsertServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Studente s = (Studente)request.getSession().getAttribute("matricola");
		String codstudente = s.getMatricola();
		String codcorso = request.getParameter("id");
		
		int corso = Integer.parseInt(codcorso);
		
		PrenotazioneDAO dao = new PrenotazioneDAO();
		dao.insert(codstudente, corso);
				
		RequestDispatcher rd = request.getRequestDispatcher("/insertCorsi.jsp");
		rd.forward(request,response);
	
	}
		
}

