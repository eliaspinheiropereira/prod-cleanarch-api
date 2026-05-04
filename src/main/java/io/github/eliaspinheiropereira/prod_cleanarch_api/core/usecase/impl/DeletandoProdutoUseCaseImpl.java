package io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.BuscarProdutoPorId;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.DeletandoProduto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.exception.ProdutoNaoEncontradoException;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.DeletandoProdutoUseCase;

import java.util.Optional;

public class DeletandoProdutoUseCaseImpl implements DeletandoProdutoUseCase {

    private final BuscarProdutoPorId buscarProdutoPorId;
    private final DeletandoProduto deletandoProduto;

    public DeletandoProdutoUseCaseImpl(BuscarProdutoPorId buscarProdutoPorId, DeletandoProduto deletandoProduto) {
        this.buscarProdutoPorId = buscarProdutoPorId;
        this.deletandoProduto = deletandoProduto;
    }

    @Override
    public void deleteById(int id) {
        Optional<Produto> produtoExistente = this.buscarProdutoPorId.find(id);

        if(produtoExistente.isEmpty()){
            throw new ProdutoNaoEncontradoException("produto não encontado");
        }

        this.deletandoProduto.deleteById(id);
    }
}
