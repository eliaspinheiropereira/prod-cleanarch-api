package io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.BuscarTodosProdutos;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.PageResult;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.Produto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.ProdutoEntityRepository;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.mapper.ProdutoEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class BuscarTodosProdutosImpl implements BuscarTodosProdutos {

    @Autowired
    private ProdutoEntityRepository produtoEntityRepository;

    @Autowired
    private ProdutoEntityMapper produtoMapper;

    @Override
    public PageResult<Produto> findAll(int page, int size) {
        var pageable = PageRequest.of(page, size);
        var pageResult = this.produtoEntityRepository.findAll(pageable);
        var produtos = pageResult.getContent().stream().map(produtoMapper::toProduto).toList();

        return new PageResult<>(
                produtos,
                page,
                size,
                pageResult.getTotalElements()
        );
    }
}
