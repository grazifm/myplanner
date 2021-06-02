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


import com.model.Livro;
import com.model.LivroService;

	@Controller
	@ComponentScan("com.model")
	
	public class LivroController {
		
		@Autowired
		private ApplicationContext context;
		@GetMapping("/liv")
		public String principal() {
			return "principal";
		}
		
		@GetMapping("/livro")
		public String formLivro(Model model) {
			model.addAttribute("livro",new Livro(null, null));
			return "formlivro";
		}
		
		@PostMapping("/livro")
		public String postLivro(@ModelAttribute Livro liv,
				                  Model model) {
			LivroService es = context.getBean(LivroService.class);
			es.inserirLivro(liv);
			model.addAttribute("tipo","LIVRO");
			return "sucesso";
		}
		
		@GetMapping("descrlivro/{id}")
	    public String read(@PathVariable("id") int id, Model model){
			LivroService cdao = context.getBean(LivroService.class);
			Map<String,Object> livro = cdao.pegarLivro(id);
			Livro liv = new Livro((String)livro.get("titulo"),(String)livro.get("autor"));
			model.addAttribute("liv",liv);
			return "formlistalivros";
	    }
		
		@GetMapping("/livros")
		public String listarLivros(Model model) {
			LivroService cdao = context.getBean(LivroService.class);
			List<Map<String,Object>> livros = cdao.pegarLivros();
			model.addAttribute("livros",livros);
			return "formlistalivros";
		}
		
		@PostMapping("/apagarlivro/{id}")
		public String deletar(@PathVariable("id") int id,Model model) {
			LivroService cdao = context.getBean(LivroService.class);
			cdao.deletarLivro(id);
			return "redirect:/livros";
		}
		
		@GetMapping("/updlivro/{id}")
	    public String atualizar(@PathVariable("id") int id, Model model) {
			LivroService cdao = context.getBean(LivroService.class);
			Map<String,Object> antigo = cdao.pegarLivro(id);
			Livro liv = new Livro((String)antigo.get("titulo"), (String)antigo.get("status"));
			model.addAttribute("antigo",liv);
			model.addAttribute("id",id);
			return "formlivroupd";
	    }
		
		@PostMapping("/updlivro/{id}")
		public String atualizar(@PathVariable("id") int id,@ModelAttribute Livro liv, Model model) {
			LivroService cdao = context.getBean(LivroService.class);
			((LivroService) cdao).atualizarLivro(id, liv);
			model.addAttribute("tipo","LIVRO");
			return "sucessoupd";
		}
		
		/*@GetMapping("/")
		public String principal(Model model) {
			String nome = "Teste";
			model.addAttribute("nome",nome);
			return "principal";
		}*/
	}


