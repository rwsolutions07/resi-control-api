package rw.solutions.api.resi.controller;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import rw.solutions.api.resi.model.dto.DadosApartamento;
import rw.solutions.api.resi.model.dto.DadosCadastroApartamento;
import rw.solutions.api.resi.service.ApartamentoService;

@CrossOrigin
@Tag(name = "Apartamento", description = "Métodos de apartamentos")
@RestController
@RequestMapping("/apartamento")
@SecurityRequirement(name = "bearer-key")
public class ApartamentoController {
	
	
	private static Logger log = Logger.getLogger(ApartamentoController.class);
	
	@Autowired
	private ApartamentoService service;
	
	@GetMapping(value = "/{torreID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosApartamento>> getApartamentos(@PathVariable(required=true) Long torreID) {
		
		log.info("Buscando os apartamentos da torre.");
		List<DadosApartamento> response = this.service.getApartamentosByTorreID(torreID);
		log.info("HTTP OK.");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(value = "/id/{apartamentoID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DadosApartamento> getApartamentoByID(@PathVariable(required=true) Long apartamentoID) {
		
		log.info("Buscando o apartamento");
		DadosApartamento response = this.service.getApartamentoByID(apartamentoID);
		log.info("HTTP OK.");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Transactional
	@PostMapping("")
	public ResponseEntity<DadosApartamento> cadastrar(@RequestBody @Valid DadosCadastroApartamento apartamento, UriComponentsBuilder uriBuilder) {
		
		DadosApartamento response  = this.service.cadastrar(apartamento);	
		URI uri = uriBuilder.path("/apartamento/id/{apartamentoID}").buildAndExpand(response.id()).toUri();
		
		log.info("HTTP CREATED");
		return ResponseEntity.created(uri).body(response);
	}
	
}
