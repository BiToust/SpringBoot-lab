package ru.arkhipov.my2TestAppSpringBoot.service;

import org.springframework.validation.BindingResult;
import ru.arkhipov.my2TestAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.my2TestAppSpringBoot.exception.ValidationFailedException;

public interface ValidationService {

    void inValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException;
}
