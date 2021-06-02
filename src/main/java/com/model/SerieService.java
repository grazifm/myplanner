package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
	public class SerieService {
		
		@Autowired
		SerieDAO cdao;
		
		public void inserirSerie(Serie l) {
			cdao.inserirSerie(l);
		}
		
		public Map<String, Object> pegarSerie(int id) {
			  return cdao.pegarSerie(id);
		  }
		  
		  public List<Map<String, Object>> pegarSeries() {
		      return cdao.pegarSeries();
		  }
		  
		  public void deletarSerie(int id) {
			  cdao.deletarSerie(id);
		  }

		public void atualizarSerie(int id, Serie tvshow) {
			cdao.atualizarSerie(id,tvshow);
			
		}

		  
	}