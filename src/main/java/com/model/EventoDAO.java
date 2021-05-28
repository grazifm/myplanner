package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventoDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirEvento(Evento evento) {
		String sql = "INSERT INTO evento(nome,localizacao,data,horario)" +
	                 " VALUES (?,?,?,?)";
		Object[] obj = new Object[4];
		//primeiro ?
		obj[0] = evento.getNome();
		//segundo ?
		obj[1] = evento.getLocalizacao();
		obj[2] = evento.getData();
		obj[3] = evento.getHorario();
		jdbc.update(sql, obj);
		
	}
	
	public Map<String, Object> pegarEvento(int id) {
    	String sql = "SELECT * FROM evento WHERE evento.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> pegarEventos() {
    	String sql = "SELECT * FROM evento";
    	List<Map<String, Object>> eventos = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return eventos;
    }
    
    public void deletarEvento(int id) {
        String sql = "DELETE FROM evento WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void atualizarEvento(int id,Evento evt) {
    	String sql = "UPDATE evento SET nome = ?, data = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		evt.getNome(), evt.getData(),id
         });
    }
}