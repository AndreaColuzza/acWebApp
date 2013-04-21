<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "it.geek.ufficio.model.Utente"%>
<%Utente ut = (Utente)session.getAttribute("utente");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
</head>
<body>
	Home&nbsp;-&nbsp;Benvenuto&nbsp;<%=ut.getNome()%>&nbsp;<%=ut.getCognome()%>
	
		<form method="GET" name="homeForm" action="listaUtenti">
		
		Lista Utenti<input type="submit" name="bottone" value="vai alla lista"/>
		</form>
		
</body>
</html>
