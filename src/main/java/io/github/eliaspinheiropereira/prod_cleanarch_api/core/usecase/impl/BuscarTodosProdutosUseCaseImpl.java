package io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.BuscarTodosProdutos;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.PageResult;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.exception.PageOrSizeException;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.BuscarTodosProdutosUseCase;

public class BuscarTodosProdutosUseCaseImpl implements BuscarTodosProdutosUseCase {

    private final BuscarTodosProdutos buscarTodosProdutos;

    public BuscarTodosProdutosUseCaseImpl(BuscarTodosProdutos buscarTodosProdutos) {
        this.buscarTodosProdutos = buscarTodosProdutos;
    }

    @Override
    public PageResult<Produto> findAll(int page, int size) {
        if(page < 0 || size <= 0){
            throw new PageOrSizeException("page ou size invalidos.");
        }
        return this.buscarTodosProdutos.findAll(page, size);
    }
}
