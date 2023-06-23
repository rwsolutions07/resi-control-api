package rw.solutions.api.resi.validacoes;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.solutions.api.resi.exceptions.ValidacaoException;
import rw.solutions.api.resi.model.repository.PortariaRpository;

@Component("PortariaValidacoes")
public class PortariaValidacoes implements ValidacoesSeExisteEncomenda {
	
	@Autowired
	private PortariaRpository repository;

	@Override
	public void ValidarSeExiste(HashMap<String, Long> dados) {
		if(null == dados.get("portariaID")) {
			throw new ValidacaoException("Portaria não existe");
		}
		
		if(!this.repository.existsById(dados.get("portariaID"))) {
			throw new ValidacaoException("Portaria não existe");
		}
	}

}
