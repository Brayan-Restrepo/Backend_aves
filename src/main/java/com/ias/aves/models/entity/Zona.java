package com.ias.aves.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="TONT_ZONAS")
public class Zona implements Serializable{

	@Id
	@Size(max = 3)
	private String cdZona;
	
	@NotBlank
	@Size(max = 45)
	private String dsNombre;

	@OneToMany(mappedBy="zona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Pais> paises;
	
	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

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
