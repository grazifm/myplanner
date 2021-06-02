package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Evento;
import com.model.EventoService;

@Controller
@ComponentScan("com.model")
public class EventoController {
	
	@Autowired
	private ApplicationContext context;
	@GetMapping("/")
	public String principal() {
		return "principal";
	}
	
	@GetMapping("/evento")
	public String formEvento(Model model) {
		model.addAttribute("evento",new Evento(null, null));
		return "formevento";
	}
	
	@PostMapping("/evento")
	public String postEvento(@ModelAttribute Evento evt,
			                  Model model) {
		EventoService es = context.getBean(EventoService.class);
		es.inserirEvento(evt);
		model.addAttribute("tipo","EVENTO");
		return "sucesso";
	}
	
	@GetMapping("descr/{id}")
    public String read(@PathVariable("id") int id, Model model){
		EventoService cdao = context.getBean(EventoService.class);
		Map<String,Object> evento = cdao.pegarEvento(id);
		Evento evt = new Evento((String)evento.get("nome"),(String)evento.get("data"));
		model.addAttribute("evt",evt);
		return "formlistaeventos";
    }
	
	@GetMapping("/eventos")
	public String listar(Model model) {
		EventoService cdao = context.getBean(EventoService.class);
		List<Map<String,Object>> eventos = cdao.pegarEventos();
		model.addAttribute("eventos",eventos);
		return "formlistaeventos";
	}
	
	@PostMapping("/apagar/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		EventoService cdao = context.getBean(EventoService.class);
		cdao.deletarEvento(id);
		return "redirect:/eventos";
	}
	
	@GetMapping("/upd/{id}")
    public String atualizar(@PathVariable("id") int id, Model model) {
		EventoService cdao = context.getBean(EventoService.class);
		Map<String,Object> antigo = cdao.pegarEvento(id);
		Evento evt = new Evento((String)antigo.get("nome"),(String)antigo.get("localizacao"),(String)antigo.get("data"));
		model.addAttribute("antigo",evt);
		model.addAttribute("id",id);
		return "formeventoupd";
	
    }
	
	@PostMapping("/upd/{id}")
	public String atualizar(@PathVariable("id") int id,@ModelAttribute Evento evt, Model model) {
		EventoService cdao = context.getBean(EventoService.class);
		cdao.atualizarEvento(id, evt);
		model.addAttribute("tipo","EVENTO");
		return "sucessoupd";
	}
	
	
}
