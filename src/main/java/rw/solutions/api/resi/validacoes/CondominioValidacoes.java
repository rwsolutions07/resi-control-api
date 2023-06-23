package rw.solutions.api.resi.validacoes;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.solutions.api.resi.exceptions.ValidacaoException;
import rw.solutions.api.resi.model.repository.CondominioRepository;

@Component("CondominioValidacoes")
public class CondominioValidacoes implements ValidacoesSeExisteEncomenda {
	
	@Autowired
	private CondominioRepository repository;

	@Override
	public void ValidarSeExiste(HashMap<String, Long> dados) {
		if(null == dados.get("condominioID")) {
			throw new ValidacaoException("Condominio não existe");
		}
		
		if(!this.repository.existsById(dados.get("condominioID"))) {
			throw new ValidacaoException("Condominio não existe");
		}
	}

}
