package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Responsavel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public Responsavel() {
		// TODO Auto-generated constructor stub
	}

}
