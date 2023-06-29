package rw.solutions.api.resi.model.dto;

import jakarta.validation.constraints.NotBlank;
import rw.solutions.api.resi.model.Sindico;

public record DadosSindico(@NotBlank String nome,
						   String linkWhatsapp,
						   String telefoneWhatsapp) {
	
	public DadosSindico(Sindico sindico) {
		this(sindico.getNome(), sindico.getLinkWhatsapp(), sindico.getTelefoneWhatsapp());
	}
	
}
