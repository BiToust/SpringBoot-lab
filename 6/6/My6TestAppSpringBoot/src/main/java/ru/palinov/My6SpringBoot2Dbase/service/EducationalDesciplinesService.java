package ru.palinov.My6SpringBoot2Dbase.service;

import ru.palinov.My6SpringBoot2Dbase.entity.EducationalDesciplines;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationalDesciplinesService
{

    List<EducationalDesciplines> getAllEducationalDesciplines();

    ResponseEntity<EducationalDesciplines> getEducationalDescipline(int id);

    ResponseEntity<EducationalDesciplines>  saveEducationalDescipline(EducationalDesciplines educationalDesciplines);

    ResponseEntity<EducationalDesciplines>  deleteEducationalDescipline(int id);
}
