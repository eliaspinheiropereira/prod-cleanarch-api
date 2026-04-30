package io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.SalvarProduto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.InserindoProdutoUseCase;

public class InserindoProdutoUseCaseImpl implements InserindoProdutoUseCase {

    private final SalvarProduto salvarProduto;

    public InserindoProdutoUseCaseImpl(SalvarProduto salvarProduto) {
        this.salvarProduto = salvarProduto;
    }

    @Override
    public void save(Produto produto) {
        this.salvarProduto.salvar(produto);
    }
}
