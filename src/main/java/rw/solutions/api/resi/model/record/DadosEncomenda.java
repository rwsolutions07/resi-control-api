package rw.solutions.api.resi.model.record;

import rw.solutions.api.resi.model.Encomenda;
import rw.solutions.api.resi.model.EncomendaStatus;

public record DadosEncomenda(Long id,
							 String nome,
							 String assinadoPor,
							 EncomendaStatus status,
							 Long moradorID,
							 Long apartamentoID) {
	
	
	public DadosEncomenda(Encomenda encomenda) {

		this(encomenda.getId(), 
			 encomenda.getNome(), 
			 encomenda.getAssinadoPor(), 
			 encomenda.getStatus(), 
			 encomenda.getMorador().getId(), 
			 encomenda.getApartamento().getId());
	
	}

}
