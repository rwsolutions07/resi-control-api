package rw.solutions.api.resi.service;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.solutions.api.resi.model.Sindico;
import rw.solutions.api.resi.model.dto.DadosSindico;
import rw.solutions.api.resi.model.repository.SindicoRepository;
import rw.solutions.api.resi.validacoes.CondominioValidacoes;

@Service
public class SindicoService {
	
	private static Logger log = Logger.getLogger(SindicoService.class);
	
	@Autowired
	private SindicoRepository repository;
	
	@Autowired
	private CondominioValidacoes validacao;

	public DadosSindico getSindicoByCondominioID(Long condominioID) {
		
		log.info("Condominio ID: " + condominioID);
		HashMap<String, Long> hashIDs = getHashMapsIDs(condominioID);
		validacao.ValidarSeExiste(hashIDs);
		
		Sindico sindico = this.repository.getSindicoByCondominioID(condominioID);
		
		return new DadosSindico(sindico);
	}

	private HashMap<String, Long> getHashMapsIDs(Long condominioID) {
		HashMap<String, Long> response = new HashMap<String, Long>();
		response.put("condominioID", condominioID);
		return response;
	}

}
