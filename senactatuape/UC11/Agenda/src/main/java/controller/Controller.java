package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/main", "/insert" })

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();

	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContatos(request, response);
		} else {
			response.sendRedirect("index.html");
		}

		// dao.testeConexao();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");
		// criando um objeto que ira receber os dados JavBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();

		// teste de recebimento da lista
		for (int i = 0; i < lista.size(); i++) {

			System.out.println(lista.get(i).getIdcon());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
			System.out.println(lista.get(i).getEmail());

		}

	}

	protected void novoContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));

		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		dao.inserirContato(contato);

		// Redirecionar para o documento agenda.jsp
		// response.sendRedirect("main");

		// criando um objeto que irá receber is dados JavaBeans
		// ArrayList<JavaBeans> lista = dao.listarContatos();

	}

}
