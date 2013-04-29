<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List, it.geek.ufficio.model.Utente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<Utente> lista = (List<Utente>) request.getAttribute("listaU");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Utenti</title>
</head>
<body>
Aggiungere un Utente??
<form name="InserisciForm" method="GET" action="insertUtente">
		<input type="submit" name="Clicca qui" value="Clicca qui"/>	
</form>		
	<table border=6 table align=center>
		<tr>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Codice Ruolo</td>
			<td>Opzione 1</td>
			<td>Opzione 2</td>
			<td>Opzione 3</td>
		</tr>	

		<%if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
		%>
		<tr>
			<td><%=lista.get(i).getNome()%></td>
			<td><%=lista.get(i).getCognome()%></td>
			<td><%=lista.get(i).getCodruolo()%></td>
			<td><a href="gestioneUtenti?view&id=aaa<%=lista.get(i).getUsername()%>">Visualizza</a></td>
			<td><a href="gestioneUtenti?set&id=bbb<%=lista.get(i).getUsername()%>">Modifica</a></td>
			<td><a href="gestioneUtenti?delete&id=ccc<%=lista.get(i).getUsername()%>">Elimina</a></td>
		</tr>
			<%}%>
		<%}%>
	</table>
</body>
</html>