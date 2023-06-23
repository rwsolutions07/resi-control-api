package rw.solutions.api.resi.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rw.solutions.api.resi.exceptions.ValidacaoException;
import rw.solutions.api.resi.model.record.DadosCadastroEncomenda;
import rw.solutions.api.resi.model.repository.ApartamentoRepository;

@Component("ApartamentoValidacoes")
public class ApartamentoValidacoes implements ValidacoesSeExisteEncomenda {
	
	@Autowired
	private ApartamentoRepository repository;

	@Override
	public void ValidarSeExiste(DadosCadastroEncomenda dados) {
		if(null == dados.apartamentoID()) {
			throw new ValidacaoException("Apartamento não existe");
		}
		
		if(!this.repository.existsById(dados.apartamentoID())) {
			throw new ValidacaoException("Apartamento não existe");
		}
	}

}
