package com.ias.aves.models.dto;

import java.io.Serializable;

public class ZonaDto implements Serializable {
	
	private String cdZona;
	private String dsNombre;
		
	public String getCdZona() {
		return cdZona;
	}

	public void setCdZona(String cdZona) {
		this.cdZona = cdZona;
	}

	public String getDsNombre() {
		return dsNombre;
	}

	public void setDsNombre(String dsNombre) {
		this.dsNombre = dsNombre;
	}

	private static final long serialVersionUID = 1L;
}
