package io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.controller;

import io.github.eliaspinheiropereira.prod_cleanarch_api.core.domain.PageResult;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.BuscandoProdutoPorIdUseCase;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.BuscarTodosProdutosUseCase;
import io.github.eliaspinheiropereira.prod_cleanarch_api.core.usecase.InserindoProdutoUseCase;
import io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.response.BuscarProdutoDTO;
import io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.request.SalvarProdutoDTO;
import io.github.eliaspinheiropereira.prod_cleanarch_api.entrypoint.controller.mapper.ProdutoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private InserindoProdutoUseCase inserindoProdutoUseCase;

    @Autowired
    private BuscarTodosProdutosUseCase buscarTodosProdutosUseCase;

    @Autowired
    private BuscandoProdutoPorIdUseCase buscandoProdutoPorIdUseCase;

    @Autowired
    private ProdutoMapper produtoMapper;

    @PostMapping
    public ResponseEntity<Void> save(
            @Valid @RequestBody SalvarProdutoDTO salvarProdutoDTO
    ){
        var produto = this.produtoMapper.toProduto(salvarProdutoDTO);
        this.inserindoProdutoUseCase.save(produto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarProdutoDTO> findById(
            @PathVariable int id
    ){
        var produto = this.buscandoProdutoPorIdUseCase.find(id);
        var buscarProdutoDTO = this.produtoMapper.toBuscarProdutoDTO(produto);
        return new ResponseEntity<>(buscarProdutoDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageResult<BuscarProdutoDTO>> findAll(
            @RequestParam int page,
            @RequestParam int size
    ){
        var result = this.buscarTodosProdutosUseCase.findAll(page, size);
        var buscarTodosProdutos = result.getContent().stream().map(produtoMapper::toBuscarProdutoDTO).toList();
        var buscarTodosProdutosDTO = new PageResult<BuscarProdutoDTO>(
                buscarTodosProdutos,
                result.getPage(),
                result.getSize(),
                result.getTotalElements()
        );

        return new ResponseEntity<>(buscarTodosProdutosDTO, HttpStatus.OK);
    }
}
