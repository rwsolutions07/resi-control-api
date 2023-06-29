package rw.solutions.api.resi.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import rw.solutions.api.resi.model.dto.DadosMoradores;
import rw.solutions.api.resi.service.MoradorService;

@CrossOrigin
@Tag(name = "Moradores", description = "Métodos de moradores")
@RestController
@RequestMapping("/morador")
@SecurityRequirement(name = "bearer-key")
public class MoradorController {
	
	private static Logger log = Logger.getLogger(MoradorController.class);
	
	@Autowired
	private MoradorService service;
	
	@GetMapping(value = "/{apartamentoID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosMoradores>> getMoradoresByApartamento(@PathVariable(required=true) Long apartamentoID) {
		log.info("Buscando os moradores do aparamento.");
		List<DadosMoradores> response = this.service.getMoradoresByApartamento(apartamentoID);
		log.info("HTTP OK.");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(value = "/id/{moradorID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DadosMoradores> getMoradorByID(@PathVariable(required=true) Long moradorID) {
		log.info("Buscando o morador");
		DadosMoradores response = this.service.getMoradorByID(moradorID);
		log.info("HTTP OK.");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
