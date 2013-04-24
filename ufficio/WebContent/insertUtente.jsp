<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
<script type="text/javascript">	
	function controllaCampi(){
		if(document.insForm.username.value==""){
			alert("username obbligatorio!");
			document.insForm.username.focus();
			return false;
		}
		else if(document.insForm.cognome.value==""){
			alert("cognome obbligatorio!");
			document.insForm.cognome.focus();
			return false;
		}
		else if(document.insForm.nome.value==""){
			alert("nome obbligatorio!");
			document.insForm.nome.focus();
			return false;
		}
		else if(document.insForm.ruolo.value==""){
			alert("ruolo obbligatorio!");
			document.insForm.ruolo.focus();
			return false;
		}
		
		if(confirm("inserire?")){
			document.insForm.submit();
		}else{
			return false;
		}
		
	}
</script>
</head>
<body>
	<form method="POST" name="homeForm" action="visualizza">
		Username&nbsp;<input type="text" name="username" /><br/>
		Password&nbsp;<input type="password" name="password" /><br/>
		Nome&nbsp;<input type="text" name="nome" /><br/>
		Cognome&nbsp;<input type="text" name="cognome" /><br/>
		Ruolo <select name="codruolo">
				<option value="1">Amministratore</option>
				<option value="2">Standard</option>
				<option value="3">Ospite</option>
				</select>
				<input type="submit" name="Inserisci"/>
	</form>

		
</body>
</html>