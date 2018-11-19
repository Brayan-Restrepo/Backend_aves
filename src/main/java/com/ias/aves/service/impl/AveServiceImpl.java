package com.ias.aves.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ias.aves.models.dto.AveDto;
import com.ias.aves.models.entity.Ave;
import com.ias.aves.repository.AveRepository;
import com.ias.aves.service.AveService;

@Service
public class AveServiceImpl implements AveService {

	@Autowired
	private AveRepository aveReepository;

	private ModelMapper modelMapper;
	
	public AveServiceImpl() {
		this.modelMapper = new ModelMapper();
	}
	
	@Override
	public List<AveDto> findAll() {
		List<Ave> aveList = (List<Ave>) this.aveReepository.findAll();		
		return aveList.stream().map(ave -> modelMapper.map(ave, AveDto.class)).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public boolean saveAve(AveDto aveDto) {
		if(Objects.nonNull(aveDto) && Objects.nonNull(aveDto.getPaises())){
			if(!this.aveReepository.existsById(aveDto.getCdAve())) {
				Ave ave = this.modelMapper.map(aveDto, Ave.class);
				this.aveReepository.save(ave);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteAve(String cdAve) {
		if(this.aveReepository.existsById(cdAve)) {
			this.aveReepository.deleteById(cdAve);
			return true;
		} else {
			return false;
		}
	}

}
