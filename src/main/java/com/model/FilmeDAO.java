package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FilmeDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirFilme(Filme filme) {
		String sql = "INSERT INTO filme(titulo,status,streaming)" +
	                 " VALUES (?,?,?)";
		Object[] obj = new Object[3];
		
		obj[0] = filme.getTitulo();
		obj[1] = filme.getStatus();
		obj[2] = filme.getStreaming();
		

		jdbc.update(sql, obj);
		
	}
	
	public Map<String, Object> pegarFilme(int id) {
    	String sql = "SELECT * FROM filme WHERE filme.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> pegarFilmes() {
    	String sql = "SELECT * FROM filme";
    	List<Map<String, Object>> filmes = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return filmes;
    }
    
    public void deletarFilme(int id) {
        String sql = "DELETE FROM filme WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void atualizarFilme(int id,Filme movie) {
    	String sql = "UPDATE filme SET status = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		movie.getStatus(),id
         });
    }
}