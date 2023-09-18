<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="ImcServlet" method="post">
		<label for="peso">Peso: </label> <input type="text" id="peso"
			name="peso"><br>
		<br> <label for="altura">Altura: </label> <input type="text"
			id="altura" name="altura"><br><br>
			
		<input type="submit" name="calcular" value="calcular">
	</form>

	<% String resultadoMsg = (String) request.getAttribute("resultadoMsg"); %>

	<h1>Resultado:</h1>
	<% if (resultadoMsg != null) {%>
	<h1><%=resultadoMsg%></h1>

	<%}%>
</body>
</html>