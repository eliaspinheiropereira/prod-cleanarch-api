package io.github.eliaspinheiropereira.prod_cleanarch_api.config;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.BuscarProdutoPorId;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.BuscarTodosProdutos;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.SalvarProduto;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.BuscandoProdutoPorIdUseCase;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.BuscarTodosProdutosUseCase;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.InserindoProdutoUseCase;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl.BuscandoProdutoPorIdUseCaseImpl;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl.BuscarTodosProdutosUseCaseImpl;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl.InserindoProdutoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public InserindoProdutoUseCase inserindoProdutoUseCase(SalvarProduto salvarProduto){
        return new InserindoProdutoUseCaseImpl(salvarProduto);
    }

    @Bean
    public BuscandoProdutoPorIdUseCase buscandoProdutoPorIdUseCase(BuscarProdutoPorId buscarProdutoPorId){
        return new BuscandoProdutoPorIdUseCaseImpl(buscarProdutoPorId);
    }

    @Bean
    public BuscarTodosProdutosUseCase buscarTodosProdutosUseCase(BuscarTodosProdutos buscarTodosProdutos){
        return new BuscarTodosProdutosUseCaseImpl(buscarTodosProdutos);
    }
}
