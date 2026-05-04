package io.github.eliaspinheiropereira.prod_cleanarch_api.config;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.dataprovider.*;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.*;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public InserindoProdutoUseCase inserindoProdutoUseCase(SalvarProduto salvarProduto){
        return new InserindoProdutoUseCaseImpl(salvarProduto);
    }

    @Bean
    public AtualizandoProdutoUseCase atualizandoProdutoUseCase(
            BuscarProdutoPorId buscarProdutoPorId,
            AtualizarProduto atualizarProduto
    ){
        return new AtualizandoProdutoUseCaseImpl(buscarProdutoPorId, atualizarProduto);
    }

    @Bean
    public DeletandoProdutoUseCase deletandoProdutoUseCase(
            BuscarProdutoPorId buscarProdutoPorId,
            DeletandoProduto deletandoProduto
    ){
        return new DeletandoProdutoUseCaseImpl(buscarProdutoPorId, deletandoProduto);
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
