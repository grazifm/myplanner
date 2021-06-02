package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
	public class LivroService {
		
		@Autowired
		LivroDAO cdao;
		
		public void inserirLivro(Livro l) {
			cdao.inserirLivro(l);
		}
		
		public Map<String, Object> pegarLivro(int id) {
			  return cdao.pegarLivro(id);
		  }
		  
		  public List<Map<String, Object>> pegarLivros() {
		      return cdao.pegarLivros();
		  }
		  
		  public void deletarLivro(int id) {
			  cdao.deletarLivro(id);
		  }

		public void atualizarLivro(int id, Livro liv) {
			cdao.atualizarLivro(id, liv);
			// TODO Auto-generated method stub
			
		}

		  
	}