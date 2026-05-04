package io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.AtualizarProduto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.ProdutoEntityRepository;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.mapper.ProdutoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarProdutoImpl implements AtualizarProduto {

    @Autowired
    private ProdutoEntityRepository produtoEntityRepository;

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Override
    public void updade(Produto produto) {
        var produtoEntity = this.produtoEntityMapper.toProdutoEntity(produto);
        this.produtoEntityRepository.save(produtoEntity);
    }
}
