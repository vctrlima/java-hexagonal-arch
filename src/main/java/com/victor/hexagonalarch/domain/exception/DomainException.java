package com.victor.hexagonalarch.domain.exception;

public class DomainException extends RuntimeException {
    public DomainException(final String message) {
        super(message);
    }
}
