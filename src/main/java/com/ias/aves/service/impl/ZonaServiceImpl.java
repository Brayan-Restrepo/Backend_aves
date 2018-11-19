package com.ias.aves.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ias.aves.models.dto.ZonaDto;
import com.ias.aves.models.entity.Zona;
import com.ias.aves.repository.ZonaRepository;
import com.ias.aves.service.ZonaService;

@Service
public class ZonaServiceImpl implements ZonaService {

	@Autowired
	private ZonaRepository zonaRepository;
	
	@Override
	public List<ZonaDto> findAll() {
		List<Zona> zonaList = (List<Zona>) this.zonaRepository.findAll();
		ModelMapper m = new ModelMapper();		
		return zonaList.stream().map(zona -> m.map(zona, ZonaDto.class)).collect(Collectors.toList());
	}

}
