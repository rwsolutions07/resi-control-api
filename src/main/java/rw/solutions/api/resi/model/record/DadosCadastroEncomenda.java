package rw.solutions.api.resi.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEncomenda(@NotBlank String nome,
									  @NotNull Long moradorID,
									  @NotNull Long apartamentoID) {

}
