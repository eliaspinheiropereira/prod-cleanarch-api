package io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.controller.mapper;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.response.BuscarProdutoDTO;
import io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.request.SalvarProdutoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    Produto toProduto(SalvarProdutoDTO salvarProdutoDTO);
    BuscarProdutoDTO toBuscarProdutoDTO(Produto produto);
}
