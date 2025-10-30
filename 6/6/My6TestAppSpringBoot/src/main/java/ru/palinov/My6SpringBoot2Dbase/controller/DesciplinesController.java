package ru.palinov.My6SpringBoot2Dbase.controller;

import ru.palinov.My6SpringBoot2Dbase.entity.EducationalDesciplines;
import ru.palinov.My6SpringBoot2Dbase.service.EducationalDesciplinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DesciplinesController
{

    // Автоматическое внедрение зависимости сервиса
    @Autowired
    private EducationalDesciplinesService educationalDesciplinesService;

    // Получение всех учебных дисциплин
    @GetMapping("/desciplines")
    public List<EducationalDesciplines> getAllDesciplines()
    {
        return educationalDesciplinesService.getAllEducationalDesciplines();
    }

    // Получение дисциплины по ID
    @GetMapping("/desciplines/{id}")
    public ResponseEntity<EducationalDesciplines> getDesciplineById(@PathVariable("id") int id)
    {
        return educationalDesciplinesService.getEducationalDescipline(id);
    }

    // Создание новой дисциплины
    @PostMapping("/descipline")
    public ResponseEntity<EducationalDesciplines> createDescipline(@RequestBody EducationalDesciplines educationalDesciplines)
    {
        return educationalDesciplinesService.saveEducationalDescipline(educationalDesciplines);
    }

    // Обновление существующей дисциплины
    @PutMapping("/descipline")
    public ResponseEntity<EducationalDesciplines> saveDescipline(@RequestBody EducationalDesciplines educationalDesciplines)
    {
        return educationalDesciplinesService.saveEducationalDescipline(educationalDesciplines);
    }

    // Удаление дисциплины по ID
    @DeleteMapping("/descipline/{id}")
    public ResponseEntity<EducationalDesciplines> deleteDescipline(@PathVariable("id") int id)
    {
        return educationalDesciplinesService.deleteEducationalDescipline(id);
    }
}