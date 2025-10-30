package ru.palinov.My4TestAppSpringBoot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ru.palinov.My4TestAppSpringBoot.exception.UnsupportedCodeException;
import ru.palinov.My4TestAppSpringBoot.exception.ValidationFailedException;
import ru.palinov.My4TestAppSpringBoot.model.Codes;
import ru.palinov.My4TestAppSpringBoot.model.ErrorCodes;
import ru.palinov.My4TestAppSpringBoot.model.ErrorMessages;
import ru.palinov.My4TestAppSpringBoot.model.Request;
import ru.palinov.My4TestAppSpringBoot.model.Response;
import ru.palinov.My4TestAppSpringBoot.service.ModifyResponseService;
import ru.palinov.My4TestAppSpringBoot.service.ValidationService;
import ru.palinov.My4TestAppSpringBoot.util.DateTimeUtil;

@Slf4j
@RestController
public class MyController
{
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService")
                        ModifyResponseService modifyResponseService)
    {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping(value="/feedback")
    public ResponseEntity<Response> feedback(
            @Valid @RequestBody Request request,
            BindingResult bindingResult
    )
    {
        long service2ReceiveTime = System.currentTimeMillis();

        log.info("request: {}", request);

        if (request.getService1Time() != null)
        {
            long service1ToService2Time = service2ReceiveTime - request.getService1Time();
            log.info("Время (Postman -> Сервис 1 -> Сервис 2): {} мс", service1ToService2Time);
        }
        else
        {
            log.warn("Отсутствует временная метка Сервиса 1 для измерения времени");
        }

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        try
        {
            validationService.isUnsupported(request.getUid());
            validationService.isValid(bindingResult);
        }
        catch(ValidationFailedException e)
        {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (UnsupportedCodeException e)
        {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
            modifyResponseService.modify(response);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
