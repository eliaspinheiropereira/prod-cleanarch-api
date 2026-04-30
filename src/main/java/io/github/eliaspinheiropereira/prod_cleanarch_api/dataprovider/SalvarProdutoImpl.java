package io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.SalvarProduto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.ProdutoEntityRepository;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.mapper.ProdutoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarProdutoImpl implements SalvarProduto {

    @Autowired
    private ProdutoEntityRepository produtoEntityRepository;

    @Autowired
    private ProdutoEntityMapper produtoMapper;

    @Override
    public void salvar(Produto produto) {
        var produtoEntity = this.produtoMapper.toProdutoEntity(produto);
        this.produtoEntityRepository.save(produtoEntity);
    }
}
