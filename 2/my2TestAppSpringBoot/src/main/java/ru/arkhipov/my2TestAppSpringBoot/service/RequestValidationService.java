package ru.arkhipov.my2TestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.arkhipov.My2TestAppSpringBoot.model.Request;
import ru.arkhipov.my2TestAppSpringBoot.exception.UnsupportedCodeException;
import ru.arkhipov.my2TestAppSpringBoot.exception.ValidationFailedException;

@Service
public class RequestValidationService implements ValidationService {

    @Override
    public void inValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodeException {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }

        if (bindingResult.getTarget() instanceof Request) {
            Request request = (Request) bindingResult.getTarget();

            if (request.getUid() != null && request.getUid().equals("123")) {
                throw new UnsupportedCodeException("Задан неверный uid");
            }
        }
    }
}
