package com.ias.aves.service;

import java.util.List;

import com.ias.aves.models.dto.AveDto;

public interface AveService {

	public List<AveDto> findAll();
	public boolean saveAve(AveDto aveDto);
	public boolean updateAve(AveDto aveDto);
	public boolean deleteAve(String cdAve);
	public List<AveDto> buscarAve(String nombre, String zona);
}
