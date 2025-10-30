package ru.palinov.My4TestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import ru.palinov.My4TestAppSpringBoot.exception.UnsupportedCodeException;
import ru.palinov.My4TestAppSpringBoot.exception.ValidationFailedException;

@Service
public interface ValidationService
{
    void isValid(BindingResult bindingResult) throws ValidationFailedException;

    void isUnsupported(String uid) throws UnsupportedCodeException;
}
