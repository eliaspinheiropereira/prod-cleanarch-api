package io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.mapper;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.entities.ProdutoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {
    ProdutoEntity toProdutoEntity(Produto produto);
    Produto toProduto(ProdutoEntity produtoEntity);
}
