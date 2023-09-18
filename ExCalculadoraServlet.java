
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServlet;

public class ExCalculadoraServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("exCalculadora.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
       double num1 = Double.parseDouble(request.getParameter("num1"));
       double num2 = Double.parseDouble(request.getParameter("num2"));
       String operacao = request.getParameter("operacao");
        
        double resultado = 0;
        
        if (operacao.equals("soma")) {
            resultado = num1 + num2;
        }
        else if (operacao.equals("subtracao")) {
            resultado = num1 - num2;
        }
        else if (operacao.equals("multiplicacao")) {
            resultado = num1 * num2;
        }
        else if (operacao.equals("divisao")) {
            resultado = num1 / num2;
        }
        request.setAttribute("resultado", (Object)resultado);
        request.getRequestDispatcher("exCalculadora.jsp").forward((ServletRequest)request, (ServletResponse)response);
    }
}