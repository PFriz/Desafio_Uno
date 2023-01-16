package com.pfriz.desafiouno.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({
    "id",
    "fechaCreacion",
    "fechaFin",
    "fechas"
})
public class PeriodoIn implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8321607838813043025L;
	
	private Long id;
	private String fechaCreacion;
	private String fechaFin;
	private List<String> fechas;
	
	
	
	public void setPeriodo(PeriodoIn otroPeriodo) {
		this.id = otroPeriodo.getId();
		this.fechaCreacion = otroPeriodo.getFechaCreacion();
		this.fechaFin = otroPeriodo.getFechaFin();
		this.fechas = otroPeriodo.getFechas();
	}
	
	@JsonProperty("id")
	public Long getId() {
		return id;
	}
	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty("fechaCreacion")
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	@JsonProperty("fechaCreacion")
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@JsonProperty("fechaFin")
	public String getFechaFin() {
		return fechaFin;
	}
	@JsonProperty("fechaFin")
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@JsonProperty("fechas")
	public List<String> getFechas() {
		return fechas;
	}
	@JsonProperty("fechas")
	public void setFechas(List<String> fechas) {
		this.fechas = fechas;
	}

}
