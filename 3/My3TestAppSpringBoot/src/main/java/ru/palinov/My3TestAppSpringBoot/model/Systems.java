package ru.palinov.My3TestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Systems {

    ERP("Enterprise Resousrce Planning"),
    CRM("Customer Relashionship Managment"),
    WMS("Warehouse Managment System");

    private final String fullName;

    Systems(String fullName) {
        this.fullName = fullName;
    }

    @JsonValue
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public String toString() {
        return this.fullName;
    }

    @JsonCreator
    public static Systems fromValue(String value) {

        if (value == null) {
            return null;
        }

        for (Systems system : Systems.values()) {
            if (system.name().equalsIgnoreCase(value) || system.getFullName().equalsIgnoreCase(value)) {

                log.info("Тип системы определен. Найденное значение: " + system.fullName);
                return system;
            }
        }

        log.error("Получено неверное значение для systemName. Допустимые значения: CRM, ERP, WMS");
        throw new IllegalArgumentException("Неизвестное значение Системы: " + value);
    }
}