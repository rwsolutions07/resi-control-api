package rw.solutions.api.resi.controller;

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
import rw.solutions.api.resi.model.record.DadosSindico;
import rw.solutions.api.resi.service.SindicoService;

@CrossOrigin
@Tag(name = "Síndico", description = "Métodos do síndico")
@RestController
@RequestMapping("/sindico")
@SecurityRequirement(name = "bearer-key")
public class SindicoController {
	
	private static Logger log = Logger.getLogger(SindicoController.class);
	
	@Autowired
	private SindicoService service;
	
	@GetMapping(value = "/{condominioID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DadosSindico> getSindico(@PathVariable(required=true) Long condominioID) {
		
		log.info("Buscando o sindico do condominio.");
		DadosSindico response = this.service.getSindicoByCondominioID(condominioID);
		log.info("HTTP OK.");
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}

}
