package model;

import java.util.ArrayList;

//Descrição dada pela  universidade sobre projetos: Conjunto de ações de caráter educativo, social, cultural, científico ou tecnológico, com objetivo específico e prazo determinado, podendo ser isolado ou vinculado a um programa de extensão.

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Projeto extends Extensao {
	
	@OneToMany
	@JoinTable(
		    name = "programa_curso",
		    joinColumns = @JoinColumn(name = "programa_id"),
		    inverseJoinColumns = @JoinColumn(name = "curso_id")
		)
	private List<Curso> cursos;
	@OneToMany
	@JoinTable(
		    name = "programa_servico",
		    joinColumns = @JoinColumn(name = "programa_id"),
		    inverseJoinColumns = @JoinColumn(name = "servico_id")
		)
	private List<Servico> servicos;
	
	public Projeto() {
		this.cursos = new ArrayList<>();
		this.servicos = new ArrayList<>();	
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	public void addServico(Servico servico) {
		this.servicos.add(servico);
	}
	
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}
	

}
