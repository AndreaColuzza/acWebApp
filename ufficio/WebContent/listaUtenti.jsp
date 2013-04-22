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

	<table border=6 table align=center>
	<tr>
		<tr>
			<b>Nome</b>
		</tr>
		<tr>
			<b>Cognome</b>
		</tr>
		<tr>
			<b>Codice Ruolo</b>
		</tr>
		<tr>
			<b>Opzione 1</b>
		</tr>
		<tr>
			<b>Opzione 2</b>
		</tr>
		<tr>
			<b>Opzione 3</b>
		</tr>
	</tr>

		<%if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
		%>
		<tr>
			<td><%=lista.get(i).getNome()%></td>
			<td><%=lista.get(i).getCognome()%></td>
			<td><%=lista.get(i).getCodruolo()%></td>
			<td><a href="gestioneUtenti?view&id=aaa<%=lista.get(i).getUsername()%>">Visualizza</a></td>
			<td><a href="gestioneUtenti?setid=bbb<%=lista.get(i).getUsername()%>">Modifica</a></td>
			<td><a href="gestioneUtenti?delete&id=ccc<%=lista.get(i).getUsername()%>">Elimina</a></td>
		</tr>
			<%}%>
		<%}%>
	</table>
</body>
</html>