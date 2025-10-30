package ru.palinov.My5TestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.palinov.My5TestAppSpringBoot.model.Request;

@Service
public interface AnnualBonusService
{
    double calculate(Request request);

    double calculateQuarterlyBonus(Request request);

    int getDaysInYear(int year);
}
