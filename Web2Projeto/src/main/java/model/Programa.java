package model;

import java.util.ArrayList;

//Descrição dada pela  universidade sobre programas: Conjunto articulado de projetos e outras ações de extensão ou cultura, preferencialmente integrando as ações de extensão, cultura, pesquisa e ensino, tendo caráter orgânico institucional, clareza de diretrizes e orientação para um objetivo comum.

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Programa extends Extensao { 

	@OneToMany
	@JoinTable(
		    name = "programa_curso",
		    joinColumns = @JoinColumn(name = "programa_id"),
		    inverseJoinColumns = @JoinColumn(name = "curso_id")
		)
	private List<Curso> cursos;
	@OneToMany
	@JoinTable(
		    name = "programa_evento",
		    joinColumns = @JoinColumn(name = "programa_id"),
		    inverseJoinColumns = @JoinColumn(name = "evento_id")
		)
	private List<Evento> eventos;
	@OneToMany
	@JoinTable(
		    name = "programa_servico",
		    joinColumns = @JoinColumn(name = "programa_id"),
		    inverseJoinColumns = @JoinColumn(name = "servico_id")
		)
	private List<Servico> servicos;
	@OneToMany
	@JoinTable(
		    name = "programa_projeto",
		    joinColumns = @JoinColumn(name = "programa_id"),
		    inverseJoinColumns = @JoinColumn(name = "projeto_id")
		)
	private List<Projeto> projetos;
	private String local; //ex UFRRJ ou campos seropedica - ufrrj. Diferente de Obj Local que pensa em predios.
	
	public Programa() {
		this.cursos = new ArrayList<>();
		this.servicos = new ArrayList<>();
		this.eventos = new ArrayList<>();
		this.projetos = new ArrayList<>();
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

	public List<Servico> getServiços() {
		return servicos;
	}

	public void setServiços(List<Servico> servicos) {
		this.servicos = servicos;
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
	
	public void addServico(Servico servico) {
		this.servicos.add(servico);
	}
	
	public void addEvento(Evento evento) {
		this.eventos.add(evento);
	}
	
	public void addProjeto(Projeto projeto) {
		this.projetos.add(projeto);
	}
	
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}
	

}
