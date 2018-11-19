package com.ias.aves.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ias.aves.models.dto.PaisDto;
import com.ias.aves.models.entity.Pais;
import com.ias.aves.repository.PaisRepository;
import com.ias.aves.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public List<PaisDto> findAll() {
		ModelMapper m = new ModelMapper();
		List<Pais> paisList = (List<Pais>) this.paisRepository.findAll();
		return paisList.stream().map(pais -> m.map(pais, PaisDto.class)).collect(Collectors.toList());
	}

}
