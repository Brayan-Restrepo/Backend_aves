package com.ias.aves.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ias.aves.models.dto.AveDto;
import com.ias.aves.models.dto.PaisDto;
import com.ias.aves.models.dto.ResponseDto;
import com.ias.aves.models.dto.in.AveUpdateDtoIn;
import com.ias.aves.models.entity.Ave;
import com.ias.aves.models.entity.Pais;
import com.ias.aves.repository.AveRepository;
import com.ias.aves.repository.PaisRepository;
import com.ias.aves.service.AveService;

@Service
public class AveServiceImpl implements AveService {

	@Autowired
	private AveRepository aveReepository;
	
	@Autowired
	private PaisRepository paisReepository;

	private ModelMapper modelMapper;
	
	public AveServiceImpl() {
		this.modelMapper = new ModelMapper();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<AveDto> findAll() {
		List<Ave> aveList = (List<Ave>) this.aveReepository.findAll();		
		return aveList.stream().map(ave -> modelMapper.map(ave, AveDto.class)).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public ResponseDto saveAve(AveDto aveDto) {
		if(Objects.nonNull(aveDto) && Objects.nonNull(aveDto.getPaises())){
			if(!this.aveReepository.existsById(aveDto.getCdAve())) {
				Ave ave = this.modelMapper.map(aveDto, Ave.class);
				this.aveReepository.save(ave);
				
			}
			return new ResponseDto(true, "");
		} else {
			return new ResponseDto(false, "El ave no es valida");
		}
	}
	
	@Override
	@Transactional
	public ResponseDto updateAve(AveUpdateDtoIn aveUpdateDtoIn) {
		if(Objects.nonNull(aveUpdateDtoIn) 
				&& this.aveReepository.existsById(aveUpdateDtoIn.getCdAve())) {
			
			Set<Pais> paises = new HashSet<>();
			for (PaisDto paisDto : aveUpdateDtoIn.getPaises()) {
				Pais p = this.paisReepository.findById(paisDto.getCdPais()).get();
				if(Objects.nonNull(p)) {
					paises.add(p);
				}
			}
			Ave ave = this.modelMapper.map(aveUpdateDtoIn, Ave.class);
			ave.setPaises(paises);
			this.aveReepository.save(ave);			
			return new ResponseDto(true, "");
		} else {
			return new ResponseDto(false, "El ave no existe -> "+aveUpdateDtoIn.getCdAve());
		}
	}

	@Override
	@Transactional
	public ResponseDto deleteAve(String cdAve) {
		if(this.aveReepository.existsById(cdAve)) {
			this.aveReepository.deleteById(cdAve);
			return new ResponseDto(true, "");
		} else {
			return new ResponseDto(false, "El no existe -> "+cdAve);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<AveDto> buscarAve(String nombre, String zona) {
		List<Ave> aves = this.aveReepository.findByNombresLikeZonaLike(nombre.toLowerCase(), zona);
		return aves.stream().map(ave -> this.modelMapper.map(ave, AveDto.class)).collect(Collectors.toList());
	}

}
