package com.model;

//Plain Old Java Object
public class Evento {
		private int id;
		private String nome;
		private String localizacao;
		private String data;
		private String horario;

		public Evento () {}
	

		
		public Evento(String string, String string2) {
			// TODO Auto-generated constructor stub
		}
		public Evento(String nome, String localizacao, String data) {
			
			this.nome = nome;
			this.localizacao = localizacao;
			this.data = data;
			
		}
		
		public Evento(int id, String nome, String localizacao, String data, String horario) {
			super();
			this.id = id;
			this.nome = nome;
			this.localizacao = localizacao;
			this.data = data;
			this.horario = horario;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getLocalizacao() {
			return localizacao;
		}
		public void setLocalizacao(String localizacao) {
			this.localizacao = localizacao;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getHorario() {
			return horario;
		}
		public void setHorario(String horario) {
			this.horario = horario;
		}
		
}