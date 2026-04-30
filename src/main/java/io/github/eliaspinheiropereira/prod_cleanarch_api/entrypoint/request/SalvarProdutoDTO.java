package io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.request;

import jakarta.validation.constraints.NotBlank;

public record SalvarProdutoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        double preco
) {
}
