package com.ias.aves.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ias.aves.models.entity.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, String> {

}
