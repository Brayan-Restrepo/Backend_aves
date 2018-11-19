package com.ias.aves.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="TONT_PAISES")
public class Pais implements Serializable{

	@Id
	@Size(max = 3)
	private String cdPais;
	
	@NotBlank
	@Size(max = 100)
	private String csNombre;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CD_ZONA")
	private Zona zona;
	
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "paises")
    private Set<Ave> aves = new HashSet<>();
	
	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Set<Ave> getAves() {
		return aves;
	}

	public void setAves(Set<Ave> aves) {
		this.aves = aves;
	}

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

	private static final long serialVersionUID = 1L;
}
