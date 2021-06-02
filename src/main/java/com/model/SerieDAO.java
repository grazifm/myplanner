package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SerieDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirSerie(Serie serie) {
		String sql = "INSERT INTO serie(titulo,status,streaming,temporada)" +
	                 " VALUES (?,?,?,?)";
		Object[] obj = new Object[4];
		obj[0] = serie.getTitulo();
		obj[1] = serie.getStatus();
		obj[2] = serie.getStreaming();
		obj[3] = serie.getTemporada();

		jdbc.update(sql, obj);
		
	}
	
	public Map<String, Object> pegarSerie(int id) {
    	String sql = "SELECT * FROM serie WHERE serie.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> pegarSeries() {
    	String sql = "SELECT * FROM serie";
    	List<Map<String, Object>> series = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return series;
    }
    
    public void deletarSerie(int id) {
        String sql = "DELETE FROM serie WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void atualizarSerie(int id,Serie tvshow) {
    	String sql = "UPDATE serie SET status = ?  WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		tvshow.getStatus(),id
         });
    }
}