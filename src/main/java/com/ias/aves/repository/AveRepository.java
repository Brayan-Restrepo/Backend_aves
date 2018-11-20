package com.ias.aves.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ias.aves.models.entity.Ave;

@Repository
public interface AveRepository extends CrudRepository<Ave, String> {

	@Query("select a from Ave a"
			+ " JOIN a.paises p"
			+ " JOIN Zona z ON p.zona.cdZona = z.cdZona"
			+ " where"
			+ " (lower(a.dsNombreComun) like %:nombre% OR lower(a.dsNombreCientifico) like %:nombre%)"
			+ " AND z.cdZona like %:zona%")
	public List<Ave> findByNombresLikeZonaLike(@Param("nombre") String nombre, @Param("zona") String zona);
}
