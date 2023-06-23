package rw.solutions.api.resi.validacoes;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import rw.solutions.api.resi.exceptions.ValidacaoException;
import rw.solutions.api.resi.model.repository.SindicoRepository;

public class SindicoValidacoes implements ValidacoesSeExisteEncomenda {
	
	@Autowired
	private SindicoRepository repository;

	@Override
	public void ValidarSeExiste(HashMap<String, Long> dados) {
		if(null == dados.get("sindicoID")) {
			throw new ValidacaoException("Sindico não existe");
		}
		
		if(!this.repository.existsById(dados.get("sindicoID"))) {
			throw new ValidacaoException("Sindico não existe");
		}
	}

}
