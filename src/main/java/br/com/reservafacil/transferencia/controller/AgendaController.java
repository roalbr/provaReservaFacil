package br.com.reservafacil.transferencia.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.reservafacil.transferencia.calculo.ITaxa;
import br.com.reservafacil.transferencia.calculo.TipoTaxa;
import br.com.reservafacil.transferencia.dao.AgendaDAO;
import br.com.reservafacil.transferencia.model.Agenda;

/**
 * AgendaController: Controller responsável pelos acionamentos das paginas de agendamento e lista de transferencia.
 * @author Rodrigo
 *
 */
@Controller
public class AgendaController {

		
	@RequestMapping(value = "/")
	public ModelAndView formulario(String mensagem) {
		ModelAndView model = new ModelAndView("agendamento", "command", new Agenda());
		model.addObject("tipoDeTaxas", TipoTaxa.values());
		model.addObject("mensagem", mensagem);
		return model;
	}

	@RequestMapping(value = "/adiciona", method = RequestMethod.POST)
	public ModelAndView adicionarAgendamento(@ModelAttribute Agenda agendamento, BindingResult result) {


		if(result.hasErrors())
			return formulario("Preenchimento inválido, favor verificar!");
		
		TipoTaxa tipoTaxa = agendamento.getTipoTaxa();
		
		ITaxa taxa = tipoTaxa.getTaxa();		
		BigDecimal valorTaxa = taxa.calculaTaxa(agendamento);
		agendamento.setTaxa(valorTaxa);
		new AgendaDAO().adiciona(agendamento);

		return formulario("Agendamento de Transferência Efetuado com sucesso!");
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String listarClientes(ModelMap model) {
		List<Agenda> agendamentos = (List<Agenda>) new AgendaDAO().buscaTodosAgendamentos();
		model.addAttribute("agendamentos", agendamentos);
		return "listaAgendamentos";
	}

}
