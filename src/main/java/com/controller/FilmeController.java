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


import com.model.Filme;
import com.model.FilmeService;

@Controller
@ComponentScan("com.model")

public class FilmeController {
	
	@Autowired
	private ApplicationContext context;
	@GetMapping("/movie")
	public String principal() {
		return "principal";
	}
	
	@GetMapping("/filme")
	public String formFilme(Model model) {
		model.addAttribute("filme",new Filme());
		return "formfilme";
	}
	
	@PostMapping("/filme")
	public String postFilme(@ModelAttribute Filme movie,
			                  Model model) {
		FilmeService es = context.getBean(FilmeService.class);
		es.inserirFilme(movie);
		model.addAttribute("tipo","FILME");
		return "sucesso";
	}
	
	@GetMapping("descrfilme/{id}")
    public String read(@PathVariable("id") int id, Model model){
		FilmeService cdao = context.getBean(FilmeService.class);
		Map<String,Object> filme = cdao.pegarFilme(id);
		Filme movie = new Filme((String)filme.get("titulo"),(String)filme.get("status"));
		model.addAttribute("movie",movie);
		return "formlistafilmes";
    }
	
	@GetMapping("/filmes")
	public String listarFilmes(Model model) {
		FilmeService cdao = context.getBean(FilmeService.class);
		List<Map<String,Object>> movie = cdao.pegarFilmes();
		model.addAttribute("filmes",movie);
		return "formlistafilmes";
	}
	
	@PostMapping("/apagarfilme/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		FilmeService cdao = context.getBean(FilmeService.class);
		cdao.deletarFilme(id);
		return "redirect:/filmes";
	}
	
	@GetMapping("/updfilme/{id}")
    public String atualizar(@PathVariable("id") int id, Model model) {
		FilmeService cdao = context.getBean(FilmeService.class);
		Map<String,Object> antigo = cdao.pegarFilme(id);
		Filme movie = new Filme((String)antigo.get("titulo"),(String)antigo.get("status"));
		model.addAttribute("antigo",movie);
		model.addAttribute("id",id);
		return "formfilmeupd";
    }
	
	@PostMapping("/updfilme/{id}")
	public String atualizar(@PathVariable("id") int id,@ModelAttribute Filme movie, Model model) {
		FilmeService cdao = context.getBean(FilmeService.class);
		((FilmeService) cdao).atualizarFilme(id, movie);
		model.addAttribute("tipo","FILME");
		return "sucessoupd";
	}
	
	/*@GetMapping("/")
	public String principal(Model model) {
		String nome = "Teste";
		model.addAttribute("nome",nome);
		return "principal";
	}*/
}


