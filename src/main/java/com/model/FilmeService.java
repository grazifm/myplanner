package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
	public class FilmeService {
		
		@Autowired
		FilmeDAO cdao;
		
		public void inserirFilme(Filme f) {
			cdao.inserirFilme(f);
		}
		
		public Map<String, Object> pegarFilme(int id) {
			  return cdao.pegarFilme(id);
		  }
		  
		  public List<Map<String, Object>> pegarFilmes() {
		      return cdao.pegarFilmes();
		  }
		  
		  public void deletarFilme(int id) {
			  cdao.deletarFilme(id);
		  }
		  
		  public void atualizarFilme(int id, Filme movie) {
			  cdao.atualizarFilme(id, movie);
		  }
	}

		
	