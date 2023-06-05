package rw.solutions.api.resi.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.solutions.api.resi.model.record.DadosEncomenda;
import rw.solutions.api.resi.service.EncomendaService;

@RestController
@RequestMapping("/encomenda/")
public class EncomendasController {
	
	private static Logger log = Logger.getLogger(EncomendasController.class);
	
	@Autowired
	private EncomendaService service;
	
	
	@GetMapping(value = "/{apartamentoID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosEncomenda>> getEncomendasPorApartamento(@PathVariable(required=true) Long apartamentoID) {
		
		log.info("Buscando as encomendas do apartamento.");
		List<DadosEncomenda> response = this.service.getEncomendasPorApartamento(apartamentoID);
		log.info("HTTP OK.");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@GetMapping(value = "/{encomendaID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DadosEncomenda> getEncomendaPorID(@PathVariable(required=true) Long encomendaID) {
		
		log.info("Buscando a encomenda");
		DadosEncomenda response = this.service.getEncomendaPorID(encomendaID);
		log.info("HTTP OK.");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}

}
