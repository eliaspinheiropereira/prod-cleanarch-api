package io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;

import java.util.Optional;

public interface BuscarProdutoPorId {
    Optional<Produto> find(int id);
}
