package com.model;

//Plain Old Java Object
public class Filme {
		private int id;
		private String titulo;
		private String status;
		private String streaming;
		
		
		public Filme(int id, String titulo, String status,String streaming) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.status = status;
			this.streaming = streaming;
		}
		
		public Filme(String titulo, String status) {
			super();
			this.status = status;
			this.titulo = titulo;
		}

		public Filme () {} 
		
		public int getId() {
			return id;
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
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

		public String getStreaming() {
			return streaming;
		}

		public void setStreaming(String streaming) {
			this.streaming = streaming;
		}
	
}
