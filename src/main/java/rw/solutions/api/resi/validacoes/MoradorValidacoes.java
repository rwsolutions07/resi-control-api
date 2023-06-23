package rw.solutions.api.resi.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.solutions.api.resi.exceptions.ValidacaoException;
import rw.solutions.api.resi.model.record.DadosCadastroEncomenda;
import rw.solutions.api.resi.model.repository.MoradorRepository;

@Component("MoradorValidacoes")
public class MoradorValidacoes implements ValidacoesSeExisteEncomenda {
	
	@Autowired
	private MoradorRepository repository;

	@Override
	public void ValidarSeExiste(DadosCadastroEncomenda dados) {
		if(null == dados.moradorID()) {
			throw new ValidacaoException("Morador não existe");
		}
		
		if(!this.repository.existsById(dados.moradorID())) {
			throw new ValidacaoException("Morador não existe");
		}
	}

}
