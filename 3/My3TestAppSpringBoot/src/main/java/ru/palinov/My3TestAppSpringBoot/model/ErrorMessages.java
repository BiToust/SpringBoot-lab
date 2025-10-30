package ru.palinov.My3TestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages
{
    EMPTY(""),
    VALIDATION("Ошибка валидации входящих данных"),
    UNSUPPORTED("Непредвиденная ошибка при обработке"),
    UNKNOWN("Неподдерживаемая системная ошибка");

    private final String description;

    ErrorMessages(String description)
    {
        this.description = description;
    }
    @JsonValue
    public String getName()
    {
        return description;
    }
}
