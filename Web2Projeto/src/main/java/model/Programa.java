package model;

//Descrição dada pela  universidade sobre programas: Conjunto articulado de projetos e outras ações de extensão ou cultura, preferencialmente integrando as ações de extensão, cultura, pesquisa e ensino, tendo caráter orgânico institucional, clareza de diretrizes e orientação para um objetivo comum.

import java.util.List;

public class Programa extends Extensao { 
	
	private List<Curso> cursos;
	private List<Evento> eventos;
	private List<Serviço> serviços;
	private List<Projeto> projetos;
	private String local; //ex UFRRJ ou campos seropedica - ufrrj. Diferente de Obj Local que pensa em predios.
	
	public Programa() { 
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Serviço> getServiços() {
		return serviços;
	}

	public void setServiços(List<Serviço> serviços) {
		this.serviços = serviços;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
