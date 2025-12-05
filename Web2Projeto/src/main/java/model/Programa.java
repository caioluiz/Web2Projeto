package model;

import jakarta.persistence.*;


@Entity
@Table(name = "programas")
public class Programa extends Extensao {
	
	private String cursosIds;    
    private String eventosIds;   
    private String servicosIds;  
    private String projetosIds;   

    private String duracao;      

	public String getEventosIds() {
		return eventosIds;
	}

	public void setEventosIds(String eventosIds) {
		this.eventosIds = eventosIds;
	}

	public String getCursosIds() {
		return cursosIds;
	}

	public void setCursosIds(String cursosIds) {
		this.cursosIds = cursosIds;
	}

	public String getProjetosIds() {
		return projetosIds;
	}

	public void setProjetosIds(String projetosIds) {
		this.projetosIds = projetosIds;
	}

	public String getServicosIds() {
		return servicosIds;
	}

	public void setServicosIds(String servicosIds) {
		this.servicosIds = servicosIds;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
    
}
