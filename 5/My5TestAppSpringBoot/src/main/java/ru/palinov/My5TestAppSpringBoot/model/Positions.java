package ru.palinov.My5TestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum Positions
{
    DEV("Разработчик", false),
    HR("HR-специалист", false),
    TL("Тимлид", true),
    DIR("Директор", true),
    QA("Тестировщик", false),
    PM("Менеджер проектов", true);

    private final String name;
    private final boolean isManager;

    Positions(String name, boolean isManager)
    {
        this.name = name;
        this.isManager = isManager;
    }

    @JsonValue
    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @JsonCreator
    public static Positions fromString(String value)
    {
        if(value == null)
        {
            return null;
        }

        for(Positions position : Positions.values())
        {
            if(position.name().equalsIgnoreCase(value) || position.getName().equalsIgnoreCase(value))
            {
                log.info("Определена должность: " + position.name);
                return position;
            }
        }

        log.error("Допустимые значения для positions: DEV, HR, TL, DIR, QA, PM");
        throw new IllegalArgumentException("Неизвестное значение должности: " + value);
    }
}