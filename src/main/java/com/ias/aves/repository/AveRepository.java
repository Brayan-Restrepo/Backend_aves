package com.ias.aves.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ias.aves.models.entity.Ave;

@Repository
public interface AveRepository extends CrudRepository<Ave, String> {

}
