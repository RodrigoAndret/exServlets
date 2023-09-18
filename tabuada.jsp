<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="TabuadaServlet" method="post">
		<label for="num1">Numero 1: </label>
		<input type="text" id="num1" name="num1"><br><br>
		
		<label for="num2">Numero 2: </label>
		<input type="text"	id="num2" name="num2"><br><br>
			
		<input type="submit" name="calcular" value="calcular">
	</form>

	<% Double resultado = (Double) request.getAttribute("resultado"); %>
	
	<h1>Resultado:</h1>
	<ul>
	<% if (resultado != null) {%>
	<li><%=resultado%></li>

	<%}%>
	</ul>

</body>
</html>