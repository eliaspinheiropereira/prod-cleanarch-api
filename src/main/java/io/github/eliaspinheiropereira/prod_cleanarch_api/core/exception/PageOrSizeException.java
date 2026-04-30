package io.github.eliaspinheiropereira.prod_cleanarch_api.core.exception;

public class PageOrSizeException extends RuntimeException{
    public PageOrSizeException(String message) {
        super(message);
    }
}
