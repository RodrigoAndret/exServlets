<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ExCalculadoraServlet" method="post">
		<label for="num1">Numero 1: </label> <input type="text" id="num1"
			name="num1"><br>
		<br> <label for="num2">Numero 2: </label> <input type="text"
			id="num2" name="num2"><br><br>
			
		<input type="submit" name="operacao" value="soma">
		<input type="submit" name="operacao" value="subtracao">
		<input type="submit" name="operacao" value="multiplicacao">
		<input type="submit" name="operacao" value="divisao">
	</form>

	<% Double resultado = (Double) request.getAttribute("resultado"); %>

	<h1>Resultado:</h1>
	<% if (resultado != null) {%>
	<h1><%=resultado%></h1>

	<%}%>
</body>
</html>