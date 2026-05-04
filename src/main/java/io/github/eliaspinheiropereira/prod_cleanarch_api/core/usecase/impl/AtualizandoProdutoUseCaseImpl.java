package io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.AtualizarProduto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.BuscarProdutoPorId;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.exception.ProdutoNaoEncontradoException;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.AtualizandoProdutoUseCase;

import java.util.Optional;

public class AtualizandoProdutoUseCaseImpl implements AtualizandoProdutoUseCase {

    private final BuscarProdutoPorId buscarProdutoPorId;
    private final AtualizarProduto atualizarProduto;

    public AtualizandoProdutoUseCaseImpl(BuscarProdutoPorId buscarProdutoPorId, AtualizarProduto atualizarProduto) {
        this.buscarProdutoPorId = buscarProdutoPorId;
        this.atualizarProduto = atualizarProduto;
    }

    @Override
    public void update(int id, Produto produto) {
        Optional<Produto> produtoExistente = this.buscarProdutoPorId.find(id);

        if(produtoExistente.isEmpty()){
            throw new ProdutoNaoEncontradoException("produto não encontrado");
        }

        Produto atualizarProduto = produtoExistente.get();
        atualizarProduto.setId(id);
        atualizarProduto.setNome(produto.getNome());
        atualizarProduto.setDescricao(produto.getDescricao());
        atualizarProduto.setPreco(produto.getPreco());
        this.atualizarProduto.updade(atualizarProduto);
    }
}
