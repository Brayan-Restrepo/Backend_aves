package com.ias.aves.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ias.aves.models.dto.AveDto;
import com.ias.aves.models.dto.PaisDto;
import com.ias.aves.models.dto.ZonaDto;
import com.ias.aves.service.AveService;
import com.ias.aves.service.PaisService;
import com.ias.aves.service.ZonaService;
import com.ias.aves.util.ConstantesUtil;


@RestController
@RequestMapping(ConstantesUtil.URL_API)
@CrossOrigin(value = "*")
public class AveController {

	@Autowired
	private AveService aveService;
	@Autowired
	private PaisService paisService;
	@Autowired
	private ZonaService zonaService;

	@GetMapping(ConstantesUtil.AVES)
	public List<AveDto> aves() {
		return this.aveService.findAll();
	}
	
	@PostMapping(ConstantesUtil.AVE)
	public boolean ave(@RequestBody AveDto aveDto) {
		
		return this.aveService.saveAve(aveDto);
	}
	
	@DeleteMapping(ConstantesUtil.AVE+"/{cdAve}")
	public boolean deleteAve(@PathVariable("cdAve") String cdAve) {
		
		return this.aveService.deleteAve(cdAve);
	}
	
	
	
	/**
	 * Listar Paises
	 * @return paises
	 */
	@GetMapping(ConstantesUtil.PAISES)
	public List<PaisDto> paises() {
		return this.paisService.findAll();
	}
	
	/**
	 * Listar Zonas
	 * @return Zonas
	 */
	@GetMapping(ConstantesUtil.ZONAS)
	public List<ZonaDto> zonas() {
		return this.zonaService.findAll();
	}
}
