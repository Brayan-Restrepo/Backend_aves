package com.ias.aves.service;

import java.util.List;

import com.ias.aves.models.dto.AveDto;
import com.ias.aves.models.dto.ResponseDto;
import com.ias.aves.models.dto.in.AveUpdateDtoIn;

public interface AveService {

	public List<AveDto> findAll();
	public ResponseDto saveAve(AveDto aveDto);
	public ResponseDto updateAve(AveUpdateDtoIn aveUpdateDtoIn);
	public ResponseDto deleteAve(String cdAve);
	public List<AveDto> buscarAve(String nombre, String zona);
}
