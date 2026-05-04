package io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.DeletandoProduto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.dataprovider.repository.ProdutoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletandoProdutoImpl implements DeletandoProduto {

    @Autowired
    private ProdutoEntityRepository produtoEntityRepository;

    @Override
    public void deleteById(int id) {
        this.produtoEntityRepository.deleteById(id);
    }
}
