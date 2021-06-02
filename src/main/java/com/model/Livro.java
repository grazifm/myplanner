package com.model;

//Plain Old Java Object
public class Livro {
		private int id;
		private String titulo;
		private String autor;
		private String status;
		
		
		public Livro () {} 
		
		public int getId() {
			return id;
		}
		
		public Livro(int id, String titulo, String autor, String status) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.autor = autor;
			this.status = status;
		}
		
		public Livro( String titulo, String status) {
			this.titulo = titulo;
			this.status = status;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	
}
