package com.ias.aves.models.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="TONT_AVES")
public class Ave implements Serializable{

	@Id
	@Size(max = 5)
	private String cdAve;

	@NotBlank
	private String dsNombreComun;

	@NotBlank
	private String dsNombreCientifico;

	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "TONT_AVES_PAIS",
            joinColumns = { @JoinColumn ( name = "CDAVES") },
            inverseJoinColumns = { @JoinColumn(name = "CDPAIS") })
    private Set<Pais> paises = new HashSet<>();
	
	public Set<Pais> getPaises() {
		return paises;
	}

	public void setPaises(Set<Pais> paises) {
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
