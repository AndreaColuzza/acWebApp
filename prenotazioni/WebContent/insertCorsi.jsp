<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
<script type="text/javascript">	
	function controllaCampi(){
		if(document.insForm.cod_studente.value==""){
			alert("codice studente obbligatorio!");
			document.insForm.username.focus();
			return false;
		}
		else if(document.insForm.cod_corso.value==""){
			alert("codice corso obbligatorio!");
			document.insForm.cognome.focus();
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
		Codice Studente&nbsp;<input type="text" name="cod_studente" /><br/>
		Codice Corso&nbsp;<input type="text" name="cod_corso" /><br/>
				<input type="submit" name="Inserisci"/>
	</form>

		
</body>
</html>