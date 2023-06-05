package rw.solutions.api.resi.model.record;

import rw.solutions.api.resi.model.Encomenda;
import rw.solutions.api.resi.model.EncomendaStatus;

public record DadosEncomenda(int id,
							 String nome,
							 String assinadoPor,
							 EncomendaStatus status,
							 int moradorID,
							 int apartamentoID) {
	
	
	public DadosEncomenda(Encomenda encomenda) {

		this(encomenda.getId(), 
			 encomenda.getNome(), 
			 encomenda.getAssinadoPor(), 
			 encomenda.getStatus(), 
			 encomenda.getMorador().getId(), 
			 encomenda.getApartamento().getId());
	
	}

}
