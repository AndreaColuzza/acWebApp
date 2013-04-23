<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
<script>
function controllaCampi(){
	//...
	
}
</script>
</head>
<body>
	<form method="POST" name="homeForm" action="insertUtenti">
		Username&nbsp;<input type="text" name="username" /><br/>
		Password&nbsp;<input type="password" name="password" /><br/>
		Nome&nbsp;<input type="text" name="nome" /><br/>
		Cognome&nbsp;<input type="password" name="cognome" /><br/>
		Codice Ruolo&nbsp;<input type="password" name="codruolo" /><br/>
		<input type="button" name="AddButton" value="Aggiungi" onclick="controllaCampi();"/>
		
		
	</form>

		
</body>
</html>