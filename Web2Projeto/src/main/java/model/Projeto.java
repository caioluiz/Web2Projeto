package model;

import java.util.ArrayList;

//Descrição dada pela  universidade sobre projetos: Conjunto de ações de caráter educativo, social, cultural, científico ou tecnológico, com objetivo específico e prazo determinado, podendo ser isolado ou vinculado a um programa de extensão.

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import model.Curso;
import model.Servico;

@Entity
@Table(name = "projetos")
public class Projeto extends Extensao {
	private String cursosIds; 
    private String servicosIds; 

    private String duracao;    

    public Projeto() { }

    public String getCursosIds() {
        return cursosIds;
    }

    public void setCursosIds(String cursosIds) {
        this.cursosIds = cursosIds;
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