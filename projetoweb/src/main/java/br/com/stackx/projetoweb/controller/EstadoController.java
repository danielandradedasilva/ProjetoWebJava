package br.com.stackx.projetoweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.stackx.projetoweb.dao.DAO;
import br.com.stackx.projetoweb.dao.EstadoDAO;
import br.com.stackx.projetoweb.exception.StackxException;
import br.com.stackx.projetoweb.model.Estado;

@Controller // informa aospring que é uma classe de controller
public class EstadoController {

	@RequestMapping(value = "/CadastroEstado", method = { RequestMethod.GET, RequestMethod.POST }) // como sera chamado
																									// pelo navegador,
																									// eo //
	// método
	public ModelAndView cadastroEstado(@ModelAttribute("SpringWeb") Estado estado, ModelMap model)
			throws StackxException {

		if (estado.getIdEstado() != 0) {
			System.out.println("recuperando o Estado");

			DAO.init();

			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.setIdEstado(estado.getIdEstado());
			estadoDAO.select();

			estado = estadoDAO;
		}

		return new ModelAndView("cadastroEstado", "command", estado);// nome do JSP, command, classe model
	}

	@RequestMapping(value = "/addEstado", method = RequestMethod.POST)
	public String addEstado(@Valid @ModelAttribute("command") Estado estado, BindingResult result, ModelMap model,
			HttpServletRequest request) throws StackxException {

		if (result.hasErrors() || result.hasFieldErrors()) {
			System.out.println("## Tem erro de validação ##");

			return "cadastroEstado";
		}

		// Inserir no BD
		DAO.init();

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.setNome(estado.getNome());
		estadoDAO.setSigla(estado.getSigla());
		estadoDAO.setCodigoIbge(estado.getCodigoIbge());

		if (estado.getIdEstado() == 0) {
			System.out.println("Fazendo o insert");
			estadoDAO.insert();
		} else {
			System.out.println("Fazendo o update");
			estadoDAO.setIdEstado(estado.getIdEstado());
			estadoDAO.update();
		}
		return "redirect:ListaEstado";// invoca a página no navegado
		// return "listaEstado;" retorna uma página JSP cujo o nome é exibeEstado
	}

	// Lista
	@RequestMapping(value = "/ListaEstado", method = { RequestMethod.GET, RequestMethod.POST })
	public String listaEstado(@RequestParam(required = false) String nomeEstadoPesquisa, ModelMap model)
			throws StackxException {

		DAO.init();
		EstadoDAO estadoDAO = new EstadoDAO();
		// chamar o método selectAll
		List<Estado> listEstados = estadoDAO.sellectAll(nomeEstadoPesquisa);

		// adicionar ele no model.addAtribute("idEstado, estado.getIdEstado())")
		model.addAttribute("estados", listEstados);
		// filtra e mostra o resultado da pesquisa, retorna o parâmetro para página
		model.addAttribute("nomeEstadoPesquisaParam", nomeEstadoPesquisa);

		// return new ModelAndView("listaEstado", "command", estado);
		return "listaEstado";

	}

	// exclusão
	@RequestMapping(value = "/RemoveEstado", method = RequestMethod.POST)
	public String removeEstado(@RequestParam(required = true) int idEstado) throws StackxException {
		DAO.init();

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.setIdEstado(idEstado);
		estadoDAO.delete();

		return "redirect:ListaEstado";
	}
}
