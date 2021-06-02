package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LivroDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirLivro(Livro livro) {
		String sql = "INSERT INTO livro(titulo,autor,status)" +
	                 " VALUES (?,?,?)";
		Object[] obj = new Object[3];
		obj[0] = livro.getTitulo();
		obj[1] = livro.getAutor();
		obj[2] = livro.getStatus();
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> pegarLivro(int id) {
    	String sql = "SELECT * FROM livro WHERE livro.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> pegarLivros() {
    	String sql = "SELECT * FROM livro";
    	List<Map<String, Object>> livros = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return livros;
    }
    
    public void deletarLivro(int id) {
        String sql = "DELETE FROM livro WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void atualizarLivro(int id,Livro liv) {
    	String sql = "UPDATE livro SET status = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		liv.getStatus(),id
         });
    }
}