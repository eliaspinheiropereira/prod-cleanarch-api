package io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.BuscarProdutoPorId;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.ProdutoEntityRepository;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.mapper.ProdutoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BuscarProdutoPorIdImpl implements BuscarProdutoPorId {

    @Autowired
    private ProdutoEntityRepository produtoEntityRepository;

    @Autowired
    private ProdutoEntityMapper produtoMapper;

    @Override
    public Optional<Produto> find(int id) {
        var produtoEntity = this.produtoEntityRepository.findById(id);
        return produtoEntity.map(produtoMapper::toProduto);
    }
}
