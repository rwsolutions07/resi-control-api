package rw.solutions.api.resi.model.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import rw.solutions.api.resi.model.OrigemEncomenda;
import rw.solutions.api.resi.model.TipoEncomenda;

public record DadosCadastroEncomenda(@NotBlank String nome,
									 @NotNull OrigemEncomenda origem,
									 @NotNull TipoEncomenda tipo,
									 @NotBlank String codigoEncomenda,
									 @NotNull Long portariaID,
									 @NotNull Long moradorID,
									 @NotNull Long apartamentoID) {

}
