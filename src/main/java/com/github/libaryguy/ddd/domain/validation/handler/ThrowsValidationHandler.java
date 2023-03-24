package com.github.libaryguy.ddd.domain.validation.handler;


import com.github.libaryguy.ddd.domain.validation.Error;
import com.github.libaryguy.ddd.domain.validation.ValidatorHandler;
import com.github.libaryguy.ddd.domain.exceptions.DomainException;

import java.util.List;

public class ThrowsValidationHandler implements ValidatorHandler {
    @Override
    public ValidatorHandler append(final Error error) {
        throw DomainException.with(error);
    }

    @Override
    public ValidatorHandler append(ValidatorHandler handler) {
        throw DomainException.with(getErrors());
    }

    @Override
    public ValidatorHandler validate(Validation handler) {
        try {
            handler.validate();
        } catch (final Exception e) {
            throw DomainException.with(new Error(e.getMessage()));
        }
        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
