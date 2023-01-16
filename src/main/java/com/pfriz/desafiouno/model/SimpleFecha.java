package com.pfriz.desafiouno.model;

public class SimpleFecha {

	private Integer anyo; 
	private Integer mes;
	private Integer dia;
	
	/**
	 * fecha debe llegar en formato yyyy-MM-dd
	 * @param fecha
	 */
	public SimpleFecha(String fecha) {
		
		String[] fechasArray = fecha.split("-");
		
		this.anyo = Integer.parseInt(fechasArray[0]);
		this.mes = Integer.parseInt(fechasArray[1]);
		this.dia = Integer.parseInt(fechasArray[2]);
	}
	
	public void addMonth() {
		mes++;
		if(mes.equals(13)) {
			mes=1;
			anyo++;
		}
	}
	
	public Integer getAnyo() {
		return anyo;
	}
	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	
	@Override
	public String toString() {
		// yyyy-MM-dd
		return anyo + "-" + 
				(mes < 10 ? "0" + mes : mes ) 
				+ "-" + 
				(dia < 10 ? "0" + dia : dia);
	}
}
