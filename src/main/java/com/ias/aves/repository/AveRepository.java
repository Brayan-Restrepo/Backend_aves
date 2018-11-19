package com.ias.aves.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ias.aves.models.entity.Ave;

@Repository
public interface AveRepository extends CrudRepository<Ave, String> {

	@Query("select a from Ave a "
			+ "JOIN TONT_AVES_PAIS ap ON ap.CDAVES = a.CDAVES "
			+ "where (a.dsNombreComun like %?1% OR a.dsNombreCientifico like %?1%)")
	public List<Ave> findByNombresLikeZonaLike(String nombre, String zona);
}
