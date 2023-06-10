package rw.solutions.api.resi.model.record;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(@NotBlank
						 String username,
						 @NotBlank
						 String password) {

}
