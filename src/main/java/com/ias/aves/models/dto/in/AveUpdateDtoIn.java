package com.ias.aves.models.dto.in;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.ias.aves.models.dto.PaisDto;

public class AveUpdateDtoIn implements Serializable {

	private String cdAve;
	private String dsNombreComun;
	private String dsNombreCientifico;
	private Set<PaisDto> paises = new HashSet<>();
	
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

	public Set<PaisDto> getPaises() {
		return paises;
	}

	public void setPaiess(Set<PaisDto> paises) {
		this.paises = paises;
	}

	private static final long serialVersionUID = 1L;
}
