package ru.palinov.My6SpringBoot2Dbase.dao;

import ru.palinov.My6SpringBoot2Dbase.entity.EducationalDesciplines;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationalDesciplinesDAO
{

    // Получение всех учебных дисциплин из базы данных
    List<EducationalDesciplines> getAllEducationalDesciplines();

    // Поиск дисциплины по уникальному идентификатору
    EducationalDesciplines getEducationalDesciplineById(int id);

    // Сохранение или обновление дисциплины в базе данных
    EducationalDesciplines saveEducationalDesciplines(EducationalDesciplines educationalDesciplines);

    // Удаление дисциплины по ID
    void deleteEducationalDesciplines(int id);
}