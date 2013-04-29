package it.geek.prenotazioni.controller;

import java.io.IOException;

import it.geek.prenotazioni.DAO.StudenteDAO;
import it.geek.prenotazioni.model.Studente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RiconoscimentoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
		String matricola = request.getParameter("matricola");
		StudenteDAO dao = new StudenteDAO();
		Studente stu=(Studente)dao.findById(matricola);
		
		if (stu==null){
		
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);		
		
		}else{
			
			HttpSession session = request.getSession();
			session.setAttribute("studente", stu);

			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}
}
