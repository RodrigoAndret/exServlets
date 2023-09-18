
package controller;

import java.util.Iterator;
import java.io.IOException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import java.util.ArrayList;
import model.Carro;
import java.util.List;
import jakarta.servlet.http.HttpServlet;

public class AluguelServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private List<Carro> carros;

	public AluguelServlet() {
		this.carros = new ArrayList<Carro>();
	}

	public void init() throws ServletException {
		this.carros.add(new Carro("Carro A"));
		this.carros.add(new Carro("Carro B"));
		this.carros.add(new Carro("Carro C"));
	}

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("carros", (Object)this.carros);
		request.getRequestDispatcher("aluguel.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String acao = request.getParameter("acao");
		final String modelo = request.getParameter("modelo");
		final String novo = request.getParameter("modeloadd");
		Carro carroSelecionado = null;

		for (final Carro carro : this.carros) {
			if (carro.getModelo().equals(modelo)) {
				carroSelecionado = carro;
				break;
			}
		}
		if (novo != null) {
			this.carros.add(new Carro(novo));
			request.setAttribute("carros", (Object)this.carros);
			request.setAttribute("mensagem2", (Object)"Ve\u00edculo adicionado com sucesso");
		}
		if (carroSelecionado != null) {
			if (acao.equals("alugar")) {
				carroSelecionado.alugar();
			}
			else if (acao.equals("devolver")) {
				carroSelecionado.devolver();
			}
		}
		request.setAttribute("carros", (Object)this.carros);
		request.setAttribute("mensagem", (Object)"Opera\u00e7\u00e3o realizada com sucesso");
		request.getRequestDispatcher("aluguel.jsp").forward((ServletRequest)request, (ServletResponse)response);
	}
}