package ru.palinov.My3TestAppSpringBoot.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ru.palinov.My3TestAppSpringBoot.model.Response;

@Slf4j
@Service("OperationUidModifier")
@Qualifier("OperationUidResponseModifierService")
public class ModifyOperationUidResponseService implements ModifyResponseService
{
    @Override
    public Response modify(Response response)
    {
        UUID newUuid = UUID.randomUUID();

        log.info("Запущено изменение поля operationUid объекта response на новое значение.");

        response.setOperationUid(newUuid.toString());

        return response;
    }
}