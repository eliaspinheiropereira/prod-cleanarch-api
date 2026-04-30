package io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.PageResult;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;

public interface BuscarTodosProdutosUseCase {
    PageResult<Produto> findAll(int page, int size);
}
