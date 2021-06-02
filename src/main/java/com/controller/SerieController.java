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


import com.model.Serie;
import com.model.SerieService;

@Controller
@ComponentScan("com.model")

public class SerieController {
	
	@Autowired
	private ApplicationContext context;
	@GetMapping("/tvshow")
	public String principal() {
		return "principal";
	}
	
	@GetMapping("/serie")
	public String formSerie(Model model) {
		model.addAttribute("serie",new Serie());
		return "formserie";
	}
	
	@PostMapping("/serie")
	public String postSerie(@ModelAttribute Serie tvshow,
			                  Model model) {
		SerieService es = context.getBean(SerieService.class);
		es.inserirSerie(tvshow);
		model.addAttribute("tipo","SERIE");
		return "sucesso";
	}
	
	@GetMapping("descrserie/{id}")
    public String read(@PathVariable("id") int id, Model model){
		SerieService cdao = context.getBean(SerieService.class);
		Map<String,Object> serie = cdao.pegarSerie(id);
		Serie tvshow = new Serie((String)serie.get("titulo"),(String)serie.get("status"), (String)serie.get("temporada"));
		model.addAttribute("tvshow",tvshow);
		return "formlistaseries";
    }
	
	@GetMapping("/series")
	public String listarSeries(Model model) {
		SerieService cdao = context.getBean(SerieService.class);
		List<Map<String,Object>> series = cdao.pegarSeries();
		model.addAttribute("series",series);
		return "formlistaseries";
	}
	
	@PostMapping("/apagarserie/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		SerieService cdao = context.getBean(SerieService.class);
		cdao.deletarSerie(id);
		return "redirect:/series";
	}
	
	@GetMapping("/updserie/{id}")
    public String atualizar(@PathVariable("id") int id, Model model) {
		SerieService cdao = context.getBean(SerieService.class);
		Map<String,Object> antigo = cdao.pegarSerie(id);
		Serie tvshow = new Serie((String)antigo.get("titulo"),(String)antigo.get("status"), (String)antigo.get("temporada"));
		model.addAttribute("antigo",tvshow);
		model.addAttribute("id",id);
		return "formserieupd";
    }
	
	@PostMapping("/updserie/{id}")
	public String atualizar(@PathVariable("id") int id,@ModelAttribute Serie tvshow, Model model) {
		SerieService cdao = context.getBean(SerieService.class);
		((SerieService) cdao).atualizarSerie(id, tvshow);
		model.addAttribute("tipo","SERIE");
		return "sucessoupd";
	}
	
	/*@GetMapping("/")
	public String principal(Model model) {
		String nome = "Teste";
		model.addAttribute("nome",nome);
		return "principal";
	}*/
}
