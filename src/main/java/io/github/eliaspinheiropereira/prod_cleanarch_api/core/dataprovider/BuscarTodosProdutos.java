package io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.PageResult;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;

public interface BuscarTodosProdutos {
    PageResult<Produto> findAll(int page, int size);
}
