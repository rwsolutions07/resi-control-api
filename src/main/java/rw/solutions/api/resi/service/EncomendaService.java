package rw.solutions.api.resi.service;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import rw.solutions.api.resi.model.Apartamento;
import rw.solutions.api.resi.model.Encomenda;
import rw.solutions.api.resi.model.Morador;
import rw.solutions.api.resi.model.Portaria;
import rw.solutions.api.resi.model.dto.DadosCadastroEncomenda;
import rw.solutions.api.resi.model.dto.DadosEncomenda;
import rw.solutions.api.resi.model.repository.ApartamentoRepository;
import rw.solutions.api.resi.model.repository.EncomendaRepository;
import rw.solutions.api.resi.model.repository.MoradorRepository;
import rw.solutions.api.resi.model.repository.PortariaRpository;
import rw.solutions.api.resi.validacoes.ValidacoesSeExisteEncomenda;

@Service
public class EncomendaService {
	
	private static Logger log = Logger.getLogger(EncomendaService.class);
	
	@Autowired
	private EncomendaRepository repository;
	
	@Autowired
	private MoradorRepository moradorRepository;
	
	@Autowired
	private ApartamentoRepository apartamentoRepository;
	
	@Autowired
	private PortariaRpository portariaRepository;
	
	@Autowired
	private List<ValidacoesSeExisteEncomenda> validadores;

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

	public DadosEncomenda cadastrarEncomenda(@Valid DadosCadastroEncomenda cadastro) {
		
		HashMap<String, Long> hashIDs = getHashMapsIDs(cadastro);
		
		validadores.forEach(v -> v.ValidarSeExiste(hashIDs));
		
		log.info("Morador ID: " + cadastro.moradorID());
		Morador morador = this.moradorRepository.getReferenceById(cadastro.moradorID());
		
		log.info("Apartamnento ID: " + cadastro.apartamentoID());
		Apartamento apartamento = this.apartamentoRepository.getReferenceById(cadastro.apartamentoID());
		
		log.info("Portaria ID: " + cadastro.portariaID());
		Portaria portaria = this.portariaRepository.getReferenceById(cadastro.portariaID());
		
		Encomenda encomenda = new Encomenda(cadastro, morador, apartamento, portaria);
		this.repository.save(encomenda);
		
		return new DadosEncomenda(encomenda);
	}

	private HashMap<String, Long> getHashMapsIDs(DadosCadastroEncomenda cadastro) {
		HashMap<String, Long> response = new HashMap<String, Long>();
		response.put("apartamentoID", cadastro.apartamentoID());
		response.put("moradorID", cadastro.moradorID());
		response.put("portariaID", cadastro.portariaID());
		return response;
	}

	
}
