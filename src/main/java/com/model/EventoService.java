package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
	public class EventoService {
		
		@Autowired
		EventoDAO cdao;
		
		public void inserirEvento(Evento e) {
			cdao.inserirEvento(e);
		}
		
		public Map<String, Object> pegarEvento(int id) {
			  return cdao.pegarEvento(id);
		  }
		  
		  public List<Map<String, Object>> pegarEventos() {
		      return cdao.pegarEventos();
		  }
		  
		  public void deletarEvento(int id) {
			  cdao.deletarEvento(id);
		  }
		  
		  public void atualizarEvento(int id, Evento evt) {
			  cdao.atualizarEvento(id, evt);
		  }
	}

		
	