package com.ias.aves.models.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AveDto implements Serializable {

	private String cdAve;
	private String dsNombreComun;
	private String dsNombreCientifico;
	private Set<PaisDto> paises = new HashSet<>();
	
	public Set<PaisDto> getPaises() {
		return paises;
	}

	public void setPaises(Set<PaisDto> paises) {
		this.paises = paises;
	}

	public String getCdAve() {
		return cdAve;
	}

	public void setCdAve(String cdAve) {
		this.cdAve = cdAve;
	}

	public String getDsNombreComun() {
		return dsNombreComun;
	}

	public void setDsNombreComun(String dsNombreComun) {
		this.dsNombreComun = dsNombreComun;
	}

	public String getDsNombreCientifico() {
		return dsNombreCientifico;
	}

	public void setDsNombreCientifico(String dsNombreCientifico) {
		this.dsNombreCientifico = dsNombreCientifico;
	}

	private static final long serialVersionUID = 1L;
}
