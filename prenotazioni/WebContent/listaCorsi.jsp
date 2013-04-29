<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List, it.geek.prenotazioni.model.Corso"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%
		List<Corso> lista = (List<Corso>) request.getAttribute("listaCorso");
	%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Corsi</title>
</head>
<body>
	<table border=6 table align=center>
		<tr>
			<td>Id</td>
			<td>Matricola</td>
		</tr>	

		<%if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {
		%>
		<tr>
			<td><%=lista.get(i).getId()%></td>
			<td><%=lista.get(i).getMatricola()%></td>
			<td><a href="insertCorsi?id=<%=lista.get(i).getId()%>">Prenota Corso</a></td>
	
		</tr>
			<%}%>
		<%}%>
	</table>
</body>
</html>