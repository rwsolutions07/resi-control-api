package rw.solutions.api.resi.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.solutions.api.resi.exceptions.ValidacaoException;
import rw.solutions.api.resi.model.record.DadosCadastroEncomenda;
import rw.solutions.api.resi.model.repository.PortariaRpository;

@Component("PortariaValidacoes")
public class PortariaValidacoes implements ValidacoesSeExisteEncomenda {
	
	@Autowired
	private PortariaRpository repository;

	@Override
	public void ValidarSeExiste(DadosCadastroEncomenda dados) {
		if(null == dados.portariaID()) {
			throw new ValidacaoException("Portaria não existe");
		}
		
		if(!this.repository.existsById(dados.moradorID())) {
			throw new ValidacaoException("Portaria não existe");
		}
	}

}
