package io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;

public interface InserindoProdutoUseCase {
    void save(Produto produto);
}
