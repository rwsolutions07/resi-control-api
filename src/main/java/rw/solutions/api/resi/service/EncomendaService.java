package rw.solutions.api.resi.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.solutions.api.resi.model.Encomenda;
import rw.solutions.api.resi.model.record.DadosEncomenda;
import rw.solutions.api.resi.model.repository.EncomendaRepository;

@Service
public class EncomendaService {
	
	private static Logger log = Logger.getLogger(EncomendaService.class);
	
	@Autowired
	private EncomendaRepository repository;

	public List<DadosEncomenda> getEncomendasPorApartamento(Long apartamentoID) {
		
		
		log.info("apartamentoID: " + apartamentoID);
		List<Encomenda> response = this.repository.getEncomendasPorApartamento(apartamentoID);
		return response.stream().map(encomenda -> new DadosEncomenda(encomenda)).toList();
	}

	public DadosEncomenda getEncomendaPorID(Long encomendaID) {
		
		log.info("encomendaID: " + encomendaID);
		Encomenda encomenda = this.repository.getEncomendaPorID(encomendaID);
		return new DadosEncomenda(encomenda);
	}

	
}
