<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "it.geek.prenotazioni.model.Studente"%>
<%Studente stu = (Studente)session.getAttribute("studente");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	Login&nbsp;-&nbsp;Benvenuto&nbsp;<%=stu.getNome()%>&nbsp;<%=stu.getCognome()%>
	<form method="GET" name="homeForm" action="listaCorsi">
		Lista Corsi&nbsp;<input type="submit" name="bottone" value="vai alla lista"/>
	</form>
	<form method="GET" name="logoutForm" action="logout">
		Esci <input type="submit" name="bottone" value="logout"/>
	</form>
</body>
</html>