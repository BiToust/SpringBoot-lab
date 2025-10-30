package ru.palinov.My3TestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.palinov.My3TestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService
{
    void modify(Request request);
}
