package br.com.vr.authorizer.infra.validation;

import javassist.NotFoundException;

import java.util.Optional;

public interface Validation<T> {
    void isValid(Optional<T> res) throws NotFoundException;
}
