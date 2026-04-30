package io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.response;

public record BuscarProdutoDTO(
        String id,
        String nome,
        String descricao,
        double preco
) {
}
