package com.ias.aves.models.dto;

import java.io.Serializable;

public class PaisDto implements Serializable {
	
	private String cdPais;	
	private String csNombre;
	private ZonaDto zona;
        
	public String getCdPais() {
		return cdPais;
	}
	public void setCdPais(String cdPais) {
		this.cdPais = cdPais;
	}
	public String getCsNombre() {
		return csNombre;
	}
	public void setCsNombre(String csNombre) {
		this.csNombre = csNombre;
	}
	public ZonaDto getZona() {
		return zona;
	}
	public void setZona(ZonaDto zona) {
		this.zona = zona;
	}
	

	private static final long serialVersionUID = 1L;
}
