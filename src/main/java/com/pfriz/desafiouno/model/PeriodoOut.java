package com.pfriz.desafiouno.model;

import java.time.LocalDate;
import java.util.List;

public class PeriodoOut extends PeriodoIn {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4623691218084395404L;
	
	public PeriodoOut() {
		// TODO Auto-generated constructor stub
	}
	
	private List<String> fechasFaltantes;

	public List<String> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<String> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}
	
	
}
