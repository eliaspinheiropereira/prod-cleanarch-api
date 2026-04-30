package io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.BuscarProdutoPorId;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.exception.ProdutoNaoEncontradoException;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.BuscandoProdutoPorIdUseCase;

public class BuscandoProdutoPorIdUseCaseImpl implements BuscandoProdutoPorIdUseCase {

    private final BuscarProdutoPorId buscarProdutoPorId;

    public BuscandoProdutoPorIdUseCaseImpl(BuscarProdutoPorId buscarProdutoPorId) {
        this.buscarProdutoPorId = buscarProdutoPorId;
    }

    @Override
    public Produto find(int id) {
        return this.buscarProdutoPorId.find(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("produto não encontrado."));
    }
}
