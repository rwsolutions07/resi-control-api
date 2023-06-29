package rw.solutions.api.resi.model.dto;

import rw.solutions.api.resi.model.Morador;

public record DadosMoradores(Long id, String nome) {

	public DadosMoradores(Morador morador) {
		this(morador.getId(), morador.getNome());
	}

}
