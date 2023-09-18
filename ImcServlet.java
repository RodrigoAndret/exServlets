
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServlet;

public class ImcServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("imc.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		double peso = Double.parseDouble(request.getParameter("peso"));
		double altura = Double.parseDouble(request.getParameter("altura"));
		double resultado = peso / (altura * altura);
		
		String resultadoMsg = "";
		
		if (resultado < 18.5) {
			resultadoMsg = "Seu IMC \u00e9 de " + resultado + ". Sua situação é de Magreza.";
		}
		else if (resultado >= 18.5 && resultado <= 24.9) {
			resultadoMsg = "Seu IMC \u00e9 de " + resultado + ". Sua situação é Normal.";
		}
		else if (resultado >= 25.0 && resultado <= 29.9) {
			resultadoMsg = "Seu IMC \u00e9 de " + resultado + ". Sua situação é de Sobrepeso.";
		}
		else if (resultado >= 30.0 && resultado <= 34.9) {
			resultadoMsg = "Seu IMC \u00e9 de " + resultado + ". Sua situação é de Obesidade grau 1.";
		}
		else if (resultado >= 35.0 && resultado <= 39.9) {
			resultadoMsg = "Seu IMC \u00e9 de " + resultado + ". Sua situação é de Obesidade grau 2.";
		}
		else if (resultado >= 40.0) {
			resultadoMsg = "Seu IMC \u00e9 de " + resultado + ". Sua situação é de Obesidade grau 3.";
		}
		request.setAttribute("resultadoMsg", (Object)resultadoMsg);
		request.getRequestDispatcher("imc.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}
}