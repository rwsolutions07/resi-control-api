package rw.solutions.api.resi.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.solutions.api.resi.model.Morador;
import rw.solutions.api.resi.model.dto.DadosMoradores;
import rw.solutions.api.resi.model.repository.MoradorRepository;

@Service
public class MoradorService {
	
	private static Logger log = Logger.getLogger(MoradorService.class);
	
	@Autowired
	private MoradorRepository repository;

	public List<DadosMoradores> getMoradoresByApartamento(Long apartamentoID) {
		log.info("apartamentoID: " + apartamentoID);
		List<Morador> response = this.repository.getMoradoresByApartamento(apartamentoID);
		return response.stream().map(morador -> new DadosMoradores(morador)).toList();
	}

	public DadosMoradores getMoradorByID(Long moradorID) {
		log.info("moradorID: " + moradorID);
		Morador morador = this.repository.getReferenceById(moradorID);
		return new DadosMoradores(morador);
	}

}
