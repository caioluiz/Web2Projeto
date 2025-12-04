package model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso extends Extensao {

	private Integer maxParticipantes;
    private String nivel;
    private LocalTime horaDeInicio;
    private LocalTime horaDeTermino;
    private String modalidade;
    private String duracaoTotal; // em meses
    private Double cargaHorariaSemanal; // semanal em horas

    public Curso() {
        super();
    }

    // Getters e setters
    public Integer getMaxParticipantes() {
    	return maxParticipantes; 
    	}
    public void setMaxParticipantes(Integer maxParticipantes) { 
    	this.maxParticipantes = maxParticipantes; 
    	}

    public String getNivel() { 
    	return nivel; 
    	}
    public void setNivel(String nivel) { 
    	this.nivel = nivel; 
    	}

    public LocalTime getHoraDeInicio() { 
    	return horaDeInicio; 
    	}
    public void setHoraDeInicio(LocalTime horaDeInicio) { 
    	this.horaDeInicio = horaDeInicio; 
    	}

    public LocalTime getHoraDeTermino() { 
    	return horaDeTermino; 
    	}
    public void setHoraDeTermino(LocalTime horaDeTermino) { 
    	this.horaDeTermino = horaDeTermino; 
    	}

    public String getModalidade() { 
    	return modalidade; 
    	}
    public void setModalidade(String modalidade) { 
    	this.modalidade = modalidade; 
    	}

    public String getDuracaoTotal() { 
    	return duracaoTotal; 
    	}
    public void setDuracaoTotal(String duracaoTotal) { 
    	this.duracaoTotal = duracaoTotal; 
    	}

    public Double getCargaHorariaSemanal() { 
    	return cargaHorariaSemanal; 
    	}
    public void setCargaHorariaSemanal(Double cargaHorariaSemanal) { 
    	this.cargaHorariaSemanal = cargaHorariaSemanal; 
    	}
}