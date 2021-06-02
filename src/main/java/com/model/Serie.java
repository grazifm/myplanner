package com.model;

//Plain Old Java Object
public class Serie {
		private int id;
		private String titulo;
		private String status;
		private String streaming;
		private String temporada;
		
		
		public Serie(int id, String titulo, String status, String streaming, String temporada) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.status = status;
			this.streaming = streaming;
			this.temporada = temporada;
		}
		
		public Serie( String titulo, String status,  String temporada) {
			super();
			this.titulo = titulo;
			this.status = status;
			this.temporada = temporada;
		}

		public Serie () {};
		
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

		public String getTemporada() {
			return temporada;
		}

		public void setTemporada(String temporada) {
			this.temporada = temporada;
		}
	
}
