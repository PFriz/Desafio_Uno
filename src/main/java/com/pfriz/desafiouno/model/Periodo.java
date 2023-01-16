package com.pfriz.desafiouno.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Deprecated
@JsonPropertyOrder({
    "id",
    "fechaCreacion",
    "fechaFin",
    "fechas",
    "fechasFaltantes"
})
public class Periodo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 870247829796492856L;
	private Integer id;
	private LocalDate fechaCreacion;
	private LocalDate fechaFin;
	private List<LocalDate> fechas;
	private List<LocalDate> fechasFaltantes;

	public List<LocalDate> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}

	@JsonProperty("id")
	public Integer getID() {
		return id;
	}

	@JsonProperty("id")
	public void setID(Integer value) {
		this.id = value;
	}

	@JsonProperty("fechaCreacion")
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	@JsonProperty("fechaCreacion")
	public void setFechaCreacion(String value) {
		 this.fechaCreacion = LocalDate.parse(value);
			
	}

	@JsonProperty("fechaFin")
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	@JsonProperty("fechaFin")
	public void setFechaFin(String value) {
		this.fechaFin = LocalDate.parse(value);
	}

	@JsonProperty("fechas")
	public List<LocalDate> getFechas() {
		return fechas;
	}

	@JsonProperty("fechas")
	public void setFechas(List<String> value) {
		this.fechas = value.stream().map(LocalDate::parse).collect(Collectors.toList());
	}
}