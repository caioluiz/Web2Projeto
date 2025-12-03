package model;

///Descrição dada pela  universidade sobre eventos: Os eventos de extensão são ações que implicam na apresentação, disseminação e, ou, exibição pública, livre ou com público específico do conhecimento ou produto cultural, artístico, esportivo, científico ou tecnológico desenvolvido, conservado ou reconhecido pela Universidade. 

import java.time.Duration;
import java.time.LocalTime;

import jakarta.persistence.Entity;

@Entity
public class Evento extends Extensao {
	private int maxParticipantes;
	private LocalTime horaDeInicio;
	private LocalTime horadeTermino;
	private double cargaHoraria;
	private Local local;
	
	public Evento() {
	}

	public int getMaxParticipantes() {
		return maxParticipantes;
	}

	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
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

	public double getCargaHoraria() {
		return cargaHoraria;
		
	}

	private void setCargaHoraria() {
		Duration duracao = Duration.between(horaDeInicio, horadeTermino);
		long cargaHorariaEmHoras = duracao.toMinutes()/60;
		this.cargaHoraria = cargaHorariaEmHoras;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}
