package rw.solutions.api.resi.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import rw.solutions.api.resi.exceptions.ValidacaoException;
import rw.solutions.api.resi.model.Apartamento;
import rw.solutions.api.resi.model.Torre;
import rw.solutions.api.resi.model.dto.DadosApartamento;
import rw.solutions.api.resi.model.dto.DadosCadastroApartamento;
import rw.solutions.api.resi.model.repository.ApartamentoRepository;
import rw.solutions.api.resi.model.repository.TorreRepository;

@Service
public class ApartamentoService {
	
	private static Logger log = Logger.getLogger(ApartamentoService.class);
	
	@Autowired
	private ApartamentoRepository repository;
	
	@Autowired
	private TorreRepository torreRepository;

	public List<DadosApartamento> getApartamentosByTorreID(Long torreID) {
		log.info("torreID: " + torreID);
		List<Apartamento> response = this.repository.getApartamentosByTorreID(torreID);
		return response.stream().map(apartamento -> new DadosApartamento(apartamento)).toList();
	}

	public DadosApartamento getApartamentoByID(Long apartamentoID) {
		log.info("apartamentoID: " + apartamentoID);
		Apartamento apartamento = this.repository.getReferenceById(apartamentoID);
		return new DadosApartamento(apartamento);
	}

	public DadosApartamento cadastrar(@Valid DadosCadastroApartamento dados) {
		
		log.info("Verificando se a torre existe: " + dados.torreID());
		if(this.torreRepository.existsById(dados.torreID())) {
			throw new ValidacaoException("Torre não existe!");
		}
		
		Torre torre = this.torreRepository.getReferenceById(dados.torreID());
		
		log.info("Salvando o apartamento: " + dados.apartamento());
		Apartamento apartamento = new Apartamento(torre, null, dados.apartamento());
		Apartamento save = this.repository.save(apartamento);
		
		return new DadosApartamento(save);
	}

}
