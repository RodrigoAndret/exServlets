
package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carro;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServlet;

public class TabuadaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private List<String> resultado;
	
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("tabuada.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		String msg = "";
		
		if (String.valueOf(num1) != null && String.valueOf(num2) != null) {
		for (int i = num1; i <= num2; ++i) {
			for (int j = 1;j < 11;j++) {
				resultado.add(i + " x " + j + " = " + i*j);
			}
		}
		} else {
			msg += "Você precisa digitar dois números!\n";
		}				
		
		if (num1 > num2) {
			msg += "O primeiro numero precisa ser menor que o primeiro!\n";
		}
		
		if (num1 < 1.0 || num1 > 10.0 || num2 < 1.0 || num2 > 10.0) {
			msg += "Os numeros precisam estar entre 1 e 10!\n";
		}
				
		request.getRequestDispatcher("tabuada.jsp").forward((ServletRequest)request, (ServletResponse)response);
	
	}
}