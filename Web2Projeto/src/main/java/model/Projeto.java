package model;

//Descrição dada pela  universidade sobre projetos: Conjunto de ações de caráter educativo, social, cultural, científico ou tecnológico, com objetivo específico e prazo determinado, podendo ser isolado ou vinculado a um programa de extensão.

import java.util.List;

public class Projeto extends Extensao {
	
	private List<Curso> cursos;
	private List<Serviço> serviços;
	private Local local;
	
	public Projeto() {
		
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Serviço> getServiços() {
		return serviços;
	}

	public void setServiços(List<Serviço> serviços) {
		this.serviços = serviços;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	

}
