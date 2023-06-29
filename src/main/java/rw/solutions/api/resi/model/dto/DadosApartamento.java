package rw.solutions.api.resi.model.dto;

import rw.solutions.api.resi.model.Apartamento;

public record DadosApartamento(Long id, String nome) {

	public DadosApartamento(Apartamento apartamento) {
		this(apartamento.getId(), apartamento.getApartamento());
	}

}
