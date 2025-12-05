package model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Servico extends Extensao {

    private String tipoServico;  // atendimento, orientação, suporte ...

    private LocalTime horarioInicio; 
    private LocalTime horarioFim;

    private String diasAtendimento; // ex: "SEG, TER, QUA"

    private String modalidadeAtendimento;  
    //presencial, online, híbrido

    public Servico() {}

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public LocalTime getHoraDeInicio() {
        return horarioInicio;
    }

    public void setHoraDeInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHoraDeTermino() {
        return horarioFim;
    }

    public void setHoraDeTermino(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getDiasAtendimento() {
        return diasAtendimento;
    }

    public void setDiasAtendimento(String diasAtendimento) {
        this.diasAtendimento = diasAtendimento;
    }

    public String getModalidadeAtendimento() {
        return modalidadeAtendimento;
    }

    public void setModalidadeAtendimento(String modalidadeAtendimento) {
        this.modalidadeAtendimento = modalidadeAtendimento;
    }
}
