package model;

//Descrição dada pela  universidade sobre cursos: Os cursos de extensão universitária são ações pedagógicas de caráter teórico e/ou, prático, com participação de forma presencial, semipresencial ou a distância, com planejamento, organização e critérios de avaliação definidos.

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Curso extends Extensao {
	private List<DayOfWeek> diasdaSemana;
	 private Local local;
	private LocalTime horaDeInicio;
	private LocalTime horadeTermino;
	private String nivel;    //basico, intermediario, avançaado...
	private int vagas;
	private String duracaoTotal; // em meses
	private double cargaHorariaSemanal; // semanal em horas
	private String modalidade; // teorico, pratico, teorico-pratico.
	
	public Curso() {
	}

	public List<DayOfWeek> getDiasdaSemana() {
		return diasdaSemana;
	}

	public void setDiasdaSemana(List<DayOfWeek> diasdaSemana) {
		this.diasdaSemana = diasdaSemana;
	}

	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}

	public void setHoraDeInicio(LocalTime horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
		setCargaHoraria();
		
	}

	public LocalTime getHoradeTermino() {
		return horadeTermino;
	}

	public void setHoradeTermino(LocalTime horadeTermino) {
		this.horadeTermino = horadeTermino;
		setCargaHoraria();
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getDuracao() {
		return duracaoTotal;
	}

	public void setDuracao(String duracaoTotal) {
		this.duracaoTotal = duracaoTotal;
	}

	public double getCargaHoraria() {
		return cargaHorariaSemanal;
	}

	private void setCargaHoraria() {
		Duration duracao = Duration.between(horaDeInicio, horadeTermino);
		long horasDeAula = duracao.toMinutes()/60;
		this.cargaHorariaSemanal = diasdaSemana.size() * horasDeAula;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

}
