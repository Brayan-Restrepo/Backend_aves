package com.ias.aves.models.dto.in;

import java.io.Serializable;

public class AveBuscarDtoIn implements Serializable {

	private String nombre;
	private String cdZona;
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCdZona() {
		return cdZona;
	}
	
	public void setCdZona(String cdZona) {
		this.cdZona = cdZona;
	}

	private static final long serialVersionUID = 1L;
}
