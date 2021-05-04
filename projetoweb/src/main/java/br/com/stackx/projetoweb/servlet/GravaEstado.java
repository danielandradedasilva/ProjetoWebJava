package br.com.stackx.projetoweb.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.stackx.projetoweb.dao.DAO;
import br.com.stackx.projetoweb.dao.EstadoDAO;
import br.com.stackx.projetoweb.exception.StackxException;

/**
 * Servlet implementation class GravaEstado
 */
//@WebServlet("/GravaEstado")
public class GravaEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GravaEstado() {
		super();

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init!!");
		// Inicializar o banco de Dados!
		DAO.init();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Destroy!!");
		// Finalizar o banco de dados!
		DAO.close();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("doPost");

			String nome = request.getParameter("nome");
			String sigla = request.getParameter("sigla");
			String codigoIbge = request.getParameter("codigoIbge");

			System.out.println("Nome: " + nome);
			System.out.println("Sigla: " + sigla);
			System.out.println("Código Ibge: " + codigoIbge);

			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.setNome(nome);
			estadoDAO.setSigla(sigla);
			estadoDAO.setCodigoIbge(Integer.parseInt(codigoIbge));
			estadoDAO.insert();

		} catch (StackxException stackxException) {
			stackxException.getException().printStackTrace();

		}

		response.sendRedirect("/projetoweb/ConfirmacaoCadastroestado.jsp");
		// MVC = MODEL (DAO) / VIEW (JSP) / CONTROLLER (SERVLET)

	}

}
