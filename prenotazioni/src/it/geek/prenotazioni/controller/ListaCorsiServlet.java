package it.geek.prenotazioni.controller;

import it.geek.prenotazioni.DAO.CorsoDAO;
import it.geek.prenotazioni.model.Corso;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListaCorsiServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CorsoDAO dao = new CorsoDAO();
		List<Corso> lista = dao.findAll();
		
		request.setAttribute("listaCorso", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaCorsi.jsp");
		rd.forward(request,response);
	}

}
