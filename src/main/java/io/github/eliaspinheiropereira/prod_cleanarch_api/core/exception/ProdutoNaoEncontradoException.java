package io.github.eliaspinheiropereira.prod_cleanarch_api.core.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{
    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}
