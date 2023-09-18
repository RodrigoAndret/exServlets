<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List,model.Carro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aluguel de carros</title>
</head>
<body>
	<%
	List<Carro> carros = (List<Carro>) request.getAttribute("carros");
	String mensagem = (String) request.getAttribute("mensagem");
	String mensagem2 = (String) request.getAttribute("mensagem2");
	%>
	
	<h1>Aluguel de carros</h1>
	
	<form action="AluguelServlet" method="post">
	<select name ="modelo">
	<%if (carros != null) {
		for (Carro carro : carros) {%>
		<option value="<%=carro.getModelo()%>"><%=carro.getModelo()%></option>
	<%} }%>
	
	</select>
	
	<input type="submit" name ="acao" value="alugar">
	<input type="submit" name ="acao" value="devolver">	
	</form>
	
	<% if (mensagem != null) { %>
	<h3><%=mensagem%></h3>
	<%} %>
	<br><br>
	
	<h2>Adicionar modelo:	</h2>
	<form  action="AluguelServlet" method="post">
	<label>Modelo do veículo: </label>
	<input type="text" id="modeloadd" name="modeloadd" required>
	<input type="submit"  value="adicionar">	
	</form>
	
	<% if (mensagem2 != null) { %>
	<h3><%=mensagem2%></h3>
	<%} %>
	<br><br>
	
	<h2>Carros disponíveis:	</h2>
	
	<table border="1">
		<tr>
			<th>Modelo</th>
			<th>Disponivel</th>
		</tr>
		
		<%if (carros != null) {
		for (Carro carro : carros) {%>
		<tr>
			<td><%=carro.getModelo()%></td>
			<td><%=carro.isDisponivel() == true ? "Sim" : "Não"%></td>
		</tr>
		<%} }%>
		
		

	</table>
	
	
	
</body>
</html>