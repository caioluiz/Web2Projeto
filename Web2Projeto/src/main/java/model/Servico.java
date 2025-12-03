package model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;

//Descrição dada pela  universidade sobre serviços: Realização de trabalho oferecido pela Universidade ou solicitado por terceiros, na forma de assessorias, consultorias, análises laboratoriais e perícias.

@Entity
public class Servico extends Extensao {
	
	private String tipoServico;
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	private List<DayOfWeek> diasAtendimento;
	private String modalidadeAtendimento;
	private float taxa;

	public Servico() {
		this.diasAtendimento = new ArrayList<>();
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalTime horarioFim) {
		this.horarioFim = horarioFim;
	}

	public List<DayOfWeek> getDiasAtendimento() {
		return diasAtendimento;
	}

	public void setDiasAtendimento(List<DayOfWeek> diasAtendimento) {
		this.diasAtendimento = diasAtendimento;
	}

	public String getModalidadeAtendimento() {
		return modalidadeAtendimento;
	}

	public void setModalidadeAtendimento(String modalidadeAtendimento) {
		this.modalidadeAtendimento = modalidadeAtendimento;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
